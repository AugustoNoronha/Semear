package br.com.semeiar.models;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Serdeable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserClientModel {
    private String id;
    private String name;
    private String email;

    public void getUserById(String ownerId) {
    }
}
