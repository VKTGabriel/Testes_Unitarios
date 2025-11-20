package br.newton.upx6.rota_literaria.api.livro.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 50, unique = true)
    private String isbn;

    @Column(nullable = false, length = 500)
    private String sinopse;

    @Column(name = "data-lancamento", nullable = false)
    private LocalDate dataLancamento;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_editora", nullable = false)
    private Editora editora;

    @ManyToMany
    @JoinTable(
            name = "livro_genero",
            joinColumns = @JoinColumn(name = "id_livro"),
            inverseJoinColumns = @JoinColumn(name = "id_genero")
    )
    private List<Genero> generos;
}
