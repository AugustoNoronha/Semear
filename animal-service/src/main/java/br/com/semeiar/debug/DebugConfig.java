package br.com.semeiar.debug;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;

@Singleton
public class DebugConfig {
    public DebugConfig(@Value("${micronaut.server.port}") String port,
                       @Value("${user.service.url:NAO_ENCONTRADO}") String userUrl) {
        System.out.println("======================================");
        System.out.println(">>> micronaut.server.port = " + port);
        System.out.println(">>> user.service.url = " + userUrl);
    }
}