package br.com.semeiar.controllers;

import br.com.semeiar.models.Animal;
import br.com.semeiar.services.interfaces.IAnimalsServices;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller("/animals")
public class AnimalsController {

    private final IAnimalsServices animalsService;

    public AnimalsController(IAnimalsServices animalsService) {
        this.animalsService = animalsService;
    }

    @Post
    public CompletableFuture<HttpResponse<Animal>> createAnimal(@Body Animal animal) {
        return animalsService.createAnimal(animal)
                .thenApply(createdAnimal -> HttpResponse.created(createdAnimal));
    }

    @Get("/{id}")
    public CompletableFuture<HttpResponse<Animal>> getAnimalById(String id) {
        return animalsService.getAnimalById(id)
                .thenApply(animal -> animal != null
                        ? HttpResponse.ok(animal)
                        : HttpResponse.notFound());
    }

    @Get
    public CompletableFuture<HttpResponse<List<Animal>>> listAnimais() {
        return animalsService.listAnimals()
                .thenApply(animals -> animals != null && !animals.isEmpty()
                        ? HttpResponse.ok(animals)
                        : HttpResponse.notFound());
    }

    @Delete("/{id}")
    public CompletableFuture<HttpResponse<Void>> delete(String id) {
        return animalsService.deleteAnimal(id)
                .thenApply(v -> HttpResponse.ok());
    }
}
