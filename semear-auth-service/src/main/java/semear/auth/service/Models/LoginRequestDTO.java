package semear.auth.service.Models;

import io.micronaut.core.annotation.Introspected;
import jakarta.validation.constraints.NotBlank;
@Introspected
public record LoginRequestDTO(
        @NotBlank String username,
        @NotBlank String password
) { }
