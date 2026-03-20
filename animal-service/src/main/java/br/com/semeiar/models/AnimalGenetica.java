package br.com.semeiar.models;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Serdeable
@Introspected
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "animais_genetica")
public class AnimalGenetica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", nullable = false, unique = true)
    private Animal animal;

    @Column(name = "linhagem_pai", length = 255)
    private String linhagemPai;

    @Column(name = "linhagem_mae", length = 255)
    private String linhagemMae;

    @Column(name = "indice_genetico", length = 255)
    private String indiceGenetico;

    @Column(name = "historico_premiacoes", columnDefinition = "TEXT")
    private String historicoPremiacoes;

    @Column(name = "aptidao_reprodutiva", columnDefinition = "TEXT")
    private String aptidaoReprodutiva;

    @Column(name = "exames_sanitarios", columnDefinition = "TEXT")
    private String examesSanitarios;

    @Column(columnDefinition = "TEXT")
    private String observacoes;
}
