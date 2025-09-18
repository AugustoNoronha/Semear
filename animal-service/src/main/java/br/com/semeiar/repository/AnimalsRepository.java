package br.com.semeiar.repository;

import br.com.semeiar.connection.DynamoDbProvider;
import br.com.semeiar.models.Animal;
import br.com.semeiar.repository.interfaces.IAnimalsRepository;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class AnimalsRepository implements IAnimalsRepository {
    private final DynamoDbTable<Animal> table;

    public AnimalsRepository(DynamoDbProvider provider,
                            @Value("${aws.dynamodb.table-animal}") String tableName) {
        this.table = provider.getEnhancedClient()
                .table(tableName, TableSchema.fromBean(Animal.class));
    }
    @Override
    public Animal save(Animal animal) {
        table.putItem(animal);
        return null;
    }

    @Override
    public Animal findById(String id) {
        return  table.getItem(r -> r.key(k -> k.partitionValue(id)));
    }

    @Override
    public List<Animal> findAll() {
        List<Animal> animals = new ArrayList<>();
        table.scan().items().forEach(animals::add);
        return animals;
    }

    @Override
    public void delete(String id) {
        table.deleteItem(r -> r.key(k -> k.partitionValue(id)));
    }
}
