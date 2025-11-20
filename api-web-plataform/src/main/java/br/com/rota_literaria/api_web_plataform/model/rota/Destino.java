package br.com.rota_literaria.api_web_plataform.model.rota;

import br.com.rota_literaria.api_web_plataform.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome-fantasia", nullable = false, length = 100)
    private String nomeFantasia;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
}
