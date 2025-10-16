package br.com.semeiar.services;

import br.com.semeiar.clients.UserCliente;
import br.com.semeiar.models.Animal;
import br.com.semeiar.models.UserClientModel;
import br.com.semeiar.repository.interfaces.IAnimalsRepository;
import br.com.semeiar.services.interfaces.IAnimalsServices;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Singleton
public class AnimalsServices implements IAnimalsServices {

    private final IAnimalsRepository animalsRepository;
    private final UserCliente userClient;

    public AnimalsServices(IAnimalsRepository animalsRepository, UserCliente userClient) {
        this.animalsRepository = animalsRepository;
        this.userClient = userClient;
    }

    @Override
    public CompletableFuture<Animal> createAnimal(Animal animal) {
        return userClient.getUserById(animal.getOwnerId())
                .thenCompose(response -> {
                    HttpResponse<UserClientModel> httpResponse = response;
                    if (httpResponse.getStatus() != HttpStatus.OK) {
                        throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado");
                    }

                    if (animal.getId() == null) {
                        animal.setId(UUID.randomUUID().toString());
                    }

                    return animalsRepository.save(animal);
                })
                .exceptionally(e -> {
                    throw new HttpStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
                });
    }

    @Override
    public CompletableFuture<Animal> getAnimalById(String id) {
        return animalsRepository.findById(id);
    }

    @Override
    public CompletableFuture<List<Animal>> listAnimals() {
        return animalsRepository.findAll();
    }

    @Override
    public CompletableFuture<Void> deleteAnimal(String id) {
        return animalsRepository.delete(id);
    }
}
