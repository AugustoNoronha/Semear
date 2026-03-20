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
@Table(name = "bois")
public class Boi extends Animal {

    @Column(name = "tipo_criacao", length = 100)
    private String tipoCriacao;

    @Column(nullable = false)
    private Boolean confinado = false;

    @Column(name = "producao_media_leite", precision = 10, scale = 2)
    private BigDecimal producaoMediaLeite;

    @Column(name = "ganho_peso_medio", precision = 10, scale = 2)
    private BigDecimal ganhoPesoMedio;
}
