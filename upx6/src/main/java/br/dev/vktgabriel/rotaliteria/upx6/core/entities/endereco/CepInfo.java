package br.dev.vktgabriel.rotaliteria.upx6.core.entities.endereco;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.EnderecoUsuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class CepInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 8, unique = true)
    private String cep;

    @Column(nullable = false, length = 100)
    private String logradouro;

    @Column(nullable = false, length = 100)
    private String estado;

    @Column(nullable = false, length = 100)
    private String bairro;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(nullable = false, length = 10)
    private String uf;

    @OneToMany(mappedBy = "cepInfo")
    private List<EnderecoUsuario> enderecoUsuarios;
}
