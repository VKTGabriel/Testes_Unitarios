package br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "destaque", nullable = false)
    private Boolean isDestaque;

    @ManyToMany(mappedBy = "generos")
    private List<Livro> livros;
}
