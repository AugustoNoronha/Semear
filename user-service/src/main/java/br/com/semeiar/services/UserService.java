package br.com.semeiar.services;

import br.com.semeiar.models.User;
import br.com.semeiar.repository.interfaces.IUserRepository;
import br.com.semeiar.services.interfaces.IUserService;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> listUsers() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void deleteUser(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
    }
}
