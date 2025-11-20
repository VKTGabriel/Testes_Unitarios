package br.dev.vktgabriel.rotaliteria.upx6.core.entities.user;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.endereco.CepInfo;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.endereco.Endereco;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class EnderecoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Column(name = "principal", nullable = false)
    private Boolean isPrincipal;
}