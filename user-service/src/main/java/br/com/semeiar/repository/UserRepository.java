package br.com.semeiar.repository;

import br.com.semeiar.connection.DynamoDbProvider;
import br.com.semeiar.models.User;
import br.com.semeiar.repository.interfaces.IUserRepository;
import jakarta.inject.Singleton;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.ArrayList;
import java.util.List;
@Singleton
public class UserRepository implements IUserRepository {
    private final DynamoDbTable<User> table;

    public UserRepository(DynamoDbProvider provider) {
        this.table = provider.getEnhancedClient()
                .table("Users", TableSchema.fromBean(User.class));
    }

    @Override
    public User save(User user) {
        table.putItem(user);
        return user;
    }

    @Override
    public User findById(String id) {
        return table.getItem(r -> r.key(k -> k.partitionValue(id)));
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        table.scan().items().forEach(users::add);
        return users;
    }

    @Override
    public void delete(String id) {
        table.deleteItem(r -> r.key(k -> k.partitionValue(id)));
    }
}
