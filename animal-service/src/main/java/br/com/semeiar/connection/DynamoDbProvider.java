package br.com.semeiar.connection;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

import java.net.URI;

@Singleton
public class DynamoDbProvider {

    private final DynamoDbEnhancedAsyncClient enhancedAsyncClient;

    public DynamoDbProvider(
            @Value("${aws.region}") String region,
            @Value("${aws.dynamodb.endpoint-override:}") String endpointOverride
    ) {
        DynamoDbAsyncClient asyncClient;

        if (endpointOverride != null && !endpointOverride.isEmpty()) {
            asyncClient = DynamoDbAsyncClient.builder()
                    .region(Region.of(region))
                    .endpointOverride(URI.create(endpointOverride))
                    .build();
        } else {
            asyncClient = DynamoDbAsyncClient.builder()
                    .region(Region.of(region))
                    .build();
        }

        this.enhancedAsyncClient = DynamoDbEnhancedAsyncClient.builder()
                .dynamoDbClient(asyncClient)
                .build();
    }

    public DynamoDbEnhancedAsyncClient getEnhancedClient() {
        return enhancedAsyncClient;
    }
}
