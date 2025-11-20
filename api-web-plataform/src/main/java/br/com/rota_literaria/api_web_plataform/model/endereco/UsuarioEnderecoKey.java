package br.com.rota_literaria.api_web_plataform.model.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
public class UsuarioEnderecoKey implements Serializable {

    @Column(name = "id_usuario")
    private UUID usuarioID;

    @Column(name = "id_endereco")
    private UUID enderecoID;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEnderecoKey that = (UsuarioEnderecoKey) o;
        return Objects.equals(usuarioID, that.usuarioID) && Objects.equals(enderecoID, that.enderecoID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioID, enderecoID);
    }
}
