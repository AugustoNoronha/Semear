package br.com.semeiar.repository.interfaces;

import br.com.semeiar.models.Animal;

import java.util.List;

public interface IAnimalsRepository {
    Animal save(Animal animal);
    Animal findById(String id);
    List<Animal> findAll();
    void delete(String id);
}
