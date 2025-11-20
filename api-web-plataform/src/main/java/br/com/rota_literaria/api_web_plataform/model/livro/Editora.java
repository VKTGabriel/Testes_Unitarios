package br.com.rota_literaria.api_web_plataform.model.livro;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    @OneToMany(mappedBy = "editora")
    private List<Livro> livros;
}
