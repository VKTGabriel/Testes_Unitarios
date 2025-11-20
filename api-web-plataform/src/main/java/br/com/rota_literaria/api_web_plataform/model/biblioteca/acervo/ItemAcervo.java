package br.com.rota_literaria.api_web_plataform.model.biblioteca.acervo;

import br.com.rota_literaria.api_web_plataform.model.biblioteca.Biblioteca;
import br.com.rota_literaria.api_web_plataform.model.emprestimo.Emprestimo;
import br.com.rota_literaria.api_web_plataform.model.livro.Livro;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class ItemAcervo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name= "id_biblioteca")
    private Biblioteca biblioteca;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    @OneToMany(mappedBy = "itemAcervo")
    private List<Emprestimo> emprestimos;

    @Enumerated(EnumType.STRING)
    private EstadoConservacao estadoConservacao;
}