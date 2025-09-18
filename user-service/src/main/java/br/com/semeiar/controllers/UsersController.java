package br.com.semeiar.controllers;

import br.com.semeiar.models.User;
import br.com.semeiar.services.interfaces.IUserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/users")
public class UsersController {
    private final IUserService userService;

    public UsersController(IUserService userService) {
        this.userService = userService;
    }

    @Post
    public HttpResponse<User> createUser(@Body User user){
        User createdUser = userService.createUser(user);
        return HttpResponse.created(createdUser);
    }

    @Get("/{id}")
    public HttpResponse<User> getUser(String id){
        User user = userService.getUserById(id);
        return user != null ? HttpResponse.ok(user) : HttpResponse.notFound();
    }
    @Get("/")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteUser(String id) {
        boolean removed = userService.deleteUser(id);
        return removed ? HttpResponse.noContent() : HttpResponse.notFound();
    }

}
