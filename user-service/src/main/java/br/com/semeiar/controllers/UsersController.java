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
    public HttpResponse<List<User>>listUsers() {
        List<User> users = userService.listUsers();
        if(users.size() > 0){
            return HttpResponse.ok(users);
        }else{
            return HttpResponse.notFound();
        }
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteUser(String id) {
        userService.deleteUser(id);
        return HttpResponse.ok();
    }

}
