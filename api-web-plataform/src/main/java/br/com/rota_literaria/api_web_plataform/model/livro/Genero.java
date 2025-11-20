package br.com.rota_literaria.api_web_plataform.model.livro;

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

    @Column(name = "nome", nullable = false, unique = true, length = 100)
    private String nome;

    @Column(name = "destaque", nullable = false)
    private Boolean isDestaque;

    @ManyToMany(mappedBy = "generos")
    private List<Livro> livros;
}
