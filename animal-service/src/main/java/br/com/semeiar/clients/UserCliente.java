package br.com.semeiar.clients;

import br.com.semeiar.models.UserClientModel;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

@Singleton
public class UserCliente {
    private final HttpClient httpClient;
    public UserCliente(@Client(id = "user-service") HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    public CompletableFuture<HttpResponse<UserClientModel>> getUserById(String id) {
        URI uri = URI.create("/users/" + id);
        HttpRequest<?> req = HttpRequest.GET(uri);

        return Mono.from(httpClient.exchange(req, Argument.of(UserClientModel.class)))
                .toFuture();
    }
}
