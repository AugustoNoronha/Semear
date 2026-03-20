package br.com.semeiar.models;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Serdeable
@Introspected
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "animais")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId; // FK mapeada apenas por ID por estarmos em serviço separado e usando Shared DB

    @Column(nullable = false, length = 20)
    private String especie;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 20)
    private String sexo;

    @Column(length = 100)
    private String raca;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(length = 50)
    private String cor;

    @Column(precision = 10, scale = 2)
    private BigDecimal peso;

    @Column(name = "registro_genealogico", length = 100)
    private String registroGenealogico;

    @Column(length = 255)
    private String finalidade;

    @Column(name = "material_genetico_disponivel", nullable = false)
    private Boolean materialGeneticoDisponivel = false;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(precision = 15, scale = 2)
    private BigDecimal valor;

    @Column(name = "status_anuncio", length = 50, nullable = false)
    private String statusAnuncio;

    @Column(length = 100)
    private String cidade;

    @Column(length = 2)
    private String estado;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    @PrePersist
    protected void onCreate() {
        dataCadastro = LocalDateTime.now();
        dataAtualizacao = LocalDateTime.now();
        if(materialGeneticoDisponivel == null) materialGeneticoDisponivel = false;
    }

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacao = LocalDateTime.now();
    }
}
