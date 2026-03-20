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
@Table(name = "animais_fotos")
public class AnimalFoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @Column(name = "url_foto", nullable = false, columnDefinition = "TEXT")
    private String urlFoto;

    @Column(nullable = false)
    private Integer ordem = 0;

    @Column(nullable = false)
    private Boolean principal = false;

    @Column(name = "data_upload", nullable = false, updatable = false)
    private LocalDateTime dataUpload;

    @PrePersist
    protected void onCreate() {
        dataUpload = LocalDateTime.now();
        if(ordem == null) ordem = 0;
        if(principal == null) principal = false;
    }
}
