package br.dev.vktgabriel.rotaliteria.upx6.core.entities.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 50)
    private String nome;

    @OneToMany(mappedBy = "grupo")
    private List<Usuario> usuarios;
}
