package br.com.semeiar.models;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Serdeable
@Introspected
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cavalos")
public class Cavalo extends Animal {

    @Column(length = 100)
    private String andar;

    @Column(precision = 5, scale = 2)
    private BigDecimal altura;

    @Column(length = 100)
    private String modalidade;

    @Column(length = 100)
    private String temperamento;
}
