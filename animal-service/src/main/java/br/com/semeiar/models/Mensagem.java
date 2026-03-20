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
@Table(name = "mensagens")
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversa_id", nullable = false)
    private Conversa conversa;

    @Column(name = "remetente_id", nullable = false)
    private Long remetenteId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String texto;

    @Column(nullable = false)
    private Boolean lida = false;

    @Column(name = "data_envio", nullable = false, updatable = false)
    private LocalDateTime dataEnvio;

    @PrePersist
    protected void onCreate() {
        dataEnvio = LocalDateTime.now();
        if(lida == null) lida = false;
    }
}
