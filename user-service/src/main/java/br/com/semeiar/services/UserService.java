package br.com.semeiar.services;

import br.com.semeiar.models.User;
import br.com.semeiar.repository.interfaces.IUserRepository;
import br.com.semeiar.services.interfaces.IUserService;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.UUID;
@Singleton
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String id) {
        userRepository.delete(id);
    }
}
