package br.com.semeiar.repository.interfaces;

import br.com.semeiar.models.User;

import java.util.List;

public interface IUserRepository {
    User save(User user);
    User findById(String id);
    List<User> findAll();
    void delete(String id);
}
