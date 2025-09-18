package br.com.semeiar.services.interfaces;

import br.com.semeiar.models.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);
    User getUserById(String id);
    List<User> listUsers();
    void deleteUser(String id);
}
