package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response;

import java.util.List;
import java.util.UUID;

public record ResponseDetailedUsuario(
        UUID id,
        String nome,
        String email,
        String cpf,
        ResponseGrupo grupo,
        List<ResponseEnderecoUsuario> enderecos) {
}
