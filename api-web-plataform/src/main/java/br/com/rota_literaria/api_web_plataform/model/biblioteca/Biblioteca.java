package br.com.rota_literaria.api_web_plataform.model.biblioteca;

import br.com.rota_literaria.api_web_plataform.model.biblioteca.acervo.ItemAcervo;
import br.com.rota_literaria.api_web_plataform.model.biblioteca.equipe.UsuarioBiblioteca;
import br.com.rota_literaria.api_web_plataform.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id_cnpj-info", nullable = false, referencedColumnName = "id")
    private CnpjInfo cnpjInfo;

    @OneToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "biblioteca")
    private List<UsuarioBiblioteca> equipe;

    @OneToMany(mappedBy = "biblioteca")
    private List<ItemAcervo> itensAcervo;
}
