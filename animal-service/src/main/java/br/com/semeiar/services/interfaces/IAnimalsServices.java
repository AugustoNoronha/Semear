package br.com.semeiar.services.interfaces;

import br.com.semeiar.models.Animal;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IAnimalsServices {
    CompletableFuture<Animal> createAnimal(Animal animal);
    CompletableFuture<Animal> getAnimalById(String id);
    CompletableFuture<List<Animal>> listAnimals();
    CompletableFuture deleteAnimal(String id);
}
