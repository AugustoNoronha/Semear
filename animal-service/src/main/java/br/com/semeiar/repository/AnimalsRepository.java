package br.com.semeiar.repository;

import br.com.semeiar.connection.DynamoDbProvider;
import br.com.semeiar.models.Animal;
import br.com.semeiar.repository.interfaces.IAnimalsRepository;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PagePublisher;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Singleton
public class AnimalsRepository implements IAnimalsRepository {

    private final DynamoDbAsyncTable<Animal> table;

    public AnimalsRepository(DynamoDbProvider provider,
                             @Value("${aws.dynamodb.table-animal}") String tableName) {
        this.table = provider.getEnhancedClient()
                .table(tableName, TableSchema.fromBean(Animal.class));
    }

    @Override
    public CompletableFuture<Animal> save(Animal animal) {
        return table.putItem(animal).thenApply(v -> animal);
    }

    @Override
    public CompletableFuture<Animal> findById(String id) {
        return table.getItem(r -> r.key(k -> k.partitionValue(id)));
    }

    @Override
    public CompletableFuture<List<Animal>> findAll() {
        PagePublisher<Animal> publisher = table.scan();
        return Flux.from(publisher.items())
                .collectList()
                .toFuture();
    }

    @Override
    public CompletableFuture<Void> delete(String id) {
        return table.deleteItem(r -> r.key(k -> k.partitionValue(id)))
                .thenApply(resp -> null);
    }
}
