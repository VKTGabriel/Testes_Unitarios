package br.newton.upx6.rota_literaria.config.security.security;

import br.newton.upx6.rota_literaria.api.security.entities.Grupo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class IdentificadorUsuario {
    private UUID id;
    private String nome;
    private String email;
    private String cpf;
    private Grupo grupo;

    public IdentificadorUsuario(UUID id, String nome, String email, String cpf, Grupo grupo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.grupo = grupo;
    }

    public List<Grupo> getGrupos() {
        return List.of(grupo);
    }
}