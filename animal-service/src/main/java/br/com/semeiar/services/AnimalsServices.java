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

import java.util.ArrayList;
import java.util.List;
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
        if(animal.getUsuarioId() == null) {
            CompletableFuture<Animal> err = new CompletableFuture<>();
            err.completeExceptionally(new HttpStatusException(HttpStatus.BAD_REQUEST, "usuarioId é obrigatório"));
            return err;
        }

        return userClient.getUserById(animal.getUsuarioId())
                .thenApply(response -> {
                    if (response.getStatus() != HttpStatus.OK) {
                        throw new HttpStatusException(HttpStatus.BAD_REQUEST, "Usuário dono não encontrado");
                    }
                    return animalsRepository.save(animal);
                })
                .exceptionally(e -> {
                    throw new HttpStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
                });
    }

    @Override
    public CompletableFuture<Animal> getAnimalById(Long id) {
        return CompletableFuture.supplyAsync(() -> animalsRepository.findById(id).orElse(null));
    }

    @Override
    public CompletableFuture<List<Animal>> listAnimals() {
        return CompletableFuture.supplyAsync(() -> {
            List<Animal> list = new ArrayList<>();
            animalsRepository.findAll().forEach(list::add);
            return list;
        });
    }

    @Override
    public CompletableFuture<Void> deleteAnimal(Long id) {
        return CompletableFuture.runAsync(() -> {
            if(animalsRepository.existsById(id)) animalsRepository.deleteById(id);
        });
    }
}
