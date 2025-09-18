package br.com.semeiar.connection;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;
@Singleton
public class DynamoDbProvider {
    private final DynamoDbEnhancedClient enhancedClient;

    public DynamoDbProvider(
            @Value("${aws.region}") String region,
            @Value("${aws.dynamodb.endpoint-override:}") String endpointOverride
    ) {
        DynamoDbClient client;

        if (endpointOverride != null && !endpointOverride.isEmpty()) {
            client = DynamoDbClient.builder()
                    .region(Region.of(region))
                    .endpointOverride(URI.create(endpointOverride))
                    .build();
        } else {
            client = DynamoDbClient.builder()
                    .region(Region.of(region))
                    .build();
        }

        this.enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(client)
                .build();
    }

    public DynamoDbEnhancedClient getEnhancedClient() {
        return enhancedClient;
    }
}
