package br.com.semeiar.repository.interfaces;

import br.com.semeiar.models.Animal;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface IAnimalsRepository extends CrudRepository<Animal, Long> {
    List<Animal> findByUsuarioId(Long usuarioId);
}
