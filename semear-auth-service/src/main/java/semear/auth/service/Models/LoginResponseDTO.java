package semear.auth.service.Models;

public record LoginResponseDTO(
        String idToken,
        String acessToken,
        String refreshToken
) { }
