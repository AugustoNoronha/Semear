package br.com.semeiar.services;

import br.com.semeiar.models.User;
import br.com.semeiar.services.interfaces.IUserService;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Singleton
public class UserService implements IUserService {
    private final Map<String, User> users = new HashMap<>();
    @Override
    public User createUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        users.put(id,user);
        return user;
    }

    @Override
    public User getUserById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> listUsers() {
        return users.values().stream().toList();
    }

    @Override
    public Boolean deleteUser(String id) {
        return users.remove(id) != null;
    }
}
