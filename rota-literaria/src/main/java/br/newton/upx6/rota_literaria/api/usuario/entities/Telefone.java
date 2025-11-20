package br.newton.upx6.rota_literaria.api.usuario.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 9)
    private String numero;

    @Column(name = "valido", nullable = false)
    private Boolean isValido;

    @OneToOne(mappedBy = "telefone")
    private Usuario usuario;
}
