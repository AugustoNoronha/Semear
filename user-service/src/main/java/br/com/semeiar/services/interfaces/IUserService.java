package br.com.semeiar.services.interfaces;

import br.com.semeiar.models.User;
import java.util.List;

public interface IUserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> listUsers();
    void deleteUser(Long id);
}
