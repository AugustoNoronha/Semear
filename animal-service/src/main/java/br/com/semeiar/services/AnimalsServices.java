package br.com.semeiar.services;

import br.com.semeiar.clients.UserClient;
import br.com.semeiar.models.Animal;
import br.com.semeiar.models.UserClientModel;
import br.com.semeiar.repository.interfaces.IAnimalsRepository;
import br.com.semeiar.services.interfaces.IAnimalsServices;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.UUID;
@Singleton
public class AnimalsServices implements IAnimalsServices {

    private final IAnimalsRepository animalsRepository;
    private final UserClient userClient;


    public AnimalsServices(IAnimalsRepository animalsRepository, UserClient userClient) {
        this.animalsRepository = animalsRepository;
        this.userClient = userClient;
    }

    @Override
    public Animal createAnimal(Animal animal) {
        try {
            UserClientModel owner = userClient.getUserById(animal.getOwnerId());
        } catch (Exception e) {
            throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Owner does not exist");
        }

        if (animal.getId() == null) {
            animal.setId(UUID.randomUUID().toString());
        }

        return animalsRepository.save(animal);
    }

    @Override
    public Animal getAnimalById(String id) {
        return animalsRepository.findById(id);
    }

    @Override
    public List<Animal> listAnimals() {
        return animalsRepository.findAll();
    }
    @Override
    public void deleteAnimal(String id) {
        animalsRepository.delete(id);
    }
}
