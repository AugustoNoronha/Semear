package br.com.semeiar.services.interfaces;

import br.com.semeiar.models.Animal;

import java.util.List;

public interface IAnimalsServices {
    Animal createAnimal(Animal animal);
    Animal getAnimalById(String id);
    List<Animal> listAnimals();
    void deleteAnimal(String id);
}
