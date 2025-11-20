package br.com.rota_literaria.api_web_plataform.model.livro;

import br.com.rota_literaria.api_web_plataform.model.biblioteca.acervo.ItemAcervo;
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

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "sinopse", nullable = false, length = 500)
    private String sinopse;

    @Column(name = "isbn", nullable = false, length = 500, unique = true)
    private String isbn;

    @Column(name = "data-lancamento", nullable = false)
    private LocalDate dataLancamento;

    @Column(name = "destaque", nullable = false)
    private Boolean isDestaque;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_editora")
    private Editora editora;

    @ManyToMany
    @JoinTable(
            name = "livro_genero",
            joinColumns = @JoinColumn(name = "id_livro"),
            inverseJoinColumns = @JoinColumn(name = "id_genero")
    )
    private List<Genero> generos;

    @OneToMany(mappedBy = "livro")
    private List<ItemAcervo> disponibilidade;
}