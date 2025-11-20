package br.com.rota_literaria.api_web_plataform.model.endereco;

import br.com.rota_literaria.api_web_plataform.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UsuarioEndereco {
    @EmbeddedId
    private UsuarioEnderecoKey usuarioEnderecoKey;

    @ManyToOne
    @MapsId("enderecoID")
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @ManyToOne
    @MapsId("usuarioID")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(nullable = false, length = 60)
    private String complemento;

    @Column(nullable = false, length = 60)
    private String referencia;

    private Boolean isPrincipal;
}
