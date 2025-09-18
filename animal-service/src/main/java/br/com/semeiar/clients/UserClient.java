package br.com.semeiar.clients;

import br.com.semeiar.models.UserClientModel;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("${user.service.url}/users")
public interface UserClient {

    @Get("/{id}")
    UserClientModel getUserById(String id);
}