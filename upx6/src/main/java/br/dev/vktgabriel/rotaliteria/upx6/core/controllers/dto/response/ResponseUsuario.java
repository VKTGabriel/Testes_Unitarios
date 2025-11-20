package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response;

import java.util.UUID;

public record ResponseUsuario(
        UUID id,
        String nome,
        String email,
        String cpf,
        ResponseGrupo grupo) {
}
