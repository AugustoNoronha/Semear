package br.com.semeiar.repository.interfaces;

import br.com.semeiar.models.User;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
}
