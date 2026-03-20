package br.com.semeiar.models;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Serdeable
@Introspected
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conversas")
public class Conversa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @Column(name = "comprador_id", nullable = false)
    private Long compradorId; // FK apenas com ID 

    @Column(name = "vendedor_id", nullable = false)
    private Long vendedorId; // FK apenas com ID

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "ultima_interacao_em", nullable = false)
    private LocalDateTime ultimaInteracaoEm;

    @Column(nullable = false)
    private Boolean ativo = true;

    @PrePersist
    protected void onCreate() {
        dataCriacao = LocalDateTime.now();
        ultimaInteracaoEm = LocalDateTime.now();
        if(ativo == null) ativo = true;
    }

    @PreUpdate
    protected void onUpdate() {
        ultimaInteracaoEm = LocalDateTime.now();
    }
}
