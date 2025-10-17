package semear.auth.service.Controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import jakarta.inject.Inject;
import semear.auth.service.Models.LoginRequestDTO;
import semear.auth.service.Services.Interfaces.ICognitoService;

@Controller("/auth")
public class AuthController {
    @Inject
    private ICognitoService cognitoService;
    public HttpResponse<?> Login(@Body LoginRequestDTO loginRequestDTO){
        try{
            var response = cognitoService.Login(loginRequestDTO.username(), loginRequestDTO.password());
            return HttpResponse.ok(response);
        }catch (Exception e){
            return HttpResponse.badRequest(e);
        }
    }

}
