package br.com.semeiar.repository.interfaces;

import br.com.semeiar.models.Animal;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IAnimalsRepository {
    CompletableFuture<Animal> save(Animal animal);
    CompletableFuture<Animal> findById(String id);
    CompletableFuture<List<Animal>>findAll();
    CompletableFuture delete(String id);
}
