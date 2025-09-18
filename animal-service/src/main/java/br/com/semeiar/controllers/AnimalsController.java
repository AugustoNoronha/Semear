package br.com.semeiar.controllers;

import br.com.semeiar.models.Animal;
import br.com.semeiar.services.interfaces.IAnimalsServices;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.util.List;
@Controller("/animals")

public class AnimalsController {

    private final IAnimalsServices animalsService;

    public AnimalsController(IAnimalsServices animalsService) {
        this.animalsService = animalsService;
    }

    @Post
    public HttpResponse<Animal> createAnimal(@Body Animal animal) {
        Animal cretaedAnimal = animalsService.createAnimal(animal);
        return HttpResponse.created(cretaedAnimal);
    }

    @Get("/{id}")
    public HttpResponse<Animal> getAnimalById(String id) {
        Animal animal = animalsService.getAnimalById(id);
        return animal != null ? HttpResponse.ok(animal) : HttpResponse.notFound();
    }

    @Get("/")
    public HttpResponse<List<Animal>>listAnimais() {
        List<Animal> animals = animalsService.listAnimals();
        if(animals.size() > 0){
            return HttpResponse.ok(animals);
        }else{
            return HttpResponse.notFound();
        }
    }

    @Delete("/{id}")
    public HttpResponse<Void> delete(String id) {
        animalsService.deleteAnimal(id);
        return HttpResponse.ok();
    }
}
