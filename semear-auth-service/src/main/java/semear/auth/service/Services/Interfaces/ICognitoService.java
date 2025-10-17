package semear.auth.service.Services.Interfaces;

import semear.auth.service.Models.LoginResponseDTO;

public interface ICognitoService {
    LoginResponseDTO Login(String username, String password);
}
