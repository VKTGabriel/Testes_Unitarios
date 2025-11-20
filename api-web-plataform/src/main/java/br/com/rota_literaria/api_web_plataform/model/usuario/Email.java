package br.com.rota_literaria.api_web_plataform.model.usuario;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "valido", nullable = false)
    private Boolean isValido;

    @OneToOne(mappedBy = "email")
    private Usuario usuario;

    public static boolean validar(String email) {
        return true;
    }
}