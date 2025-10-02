package br.com.semeiar.clients;

import br.com.semeiar.models.UserClientModel;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import org.reactivestreams.Publisher;

import java.util.concurrent.CompletableFuture;

@Client(id = "user-service")
public interface UserClient {
    @Get("/users/{id}")
    CompletableFuture<HttpResponse<UserClientModel>> getUserById(String id);
}