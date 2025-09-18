package br.com.semeiar.models;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Serdeable
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class Animal {
    private String id;
    private String ownerId;
    private String species;
    private String breed;
    private int age;
    private double price;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}
