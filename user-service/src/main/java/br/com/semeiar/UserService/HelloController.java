package br.com.semeiar.UserService;
import io.micronaut.http.annotation.*;
@Controller("/hello")
public class HelloController {
    @Get("/")
    public String hello(){
        return "SEMEAR UserService funcionando";
    }

}
