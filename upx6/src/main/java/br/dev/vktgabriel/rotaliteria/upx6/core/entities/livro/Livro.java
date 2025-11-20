package br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.biblioteca.ItemAcervo;
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

    @Column(name = "numero-paginas", nullable = false)
    private Integer numeroPaginas;

    @Column(nullable = false)
    private Integer edicao;

    @Column(name = "url_capa", nullable = false)
    private String urlCapa;

    @ManyToOne
    @JoinColumn(name = "id_editora", nullable = false)
    private Editora editora;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    @OneToMany(mappedBy = "livro")
    private List<ItemAcervo> itemAcervos;

    @ManyToMany
    @JoinTable(
            name = "livro_genero",
            joinColumns = @JoinColumn(name = "id_livro"),
            inverseJoinColumns = @JoinColumn(name = "id_genero")
    )
    private List<Genero> generos;
}