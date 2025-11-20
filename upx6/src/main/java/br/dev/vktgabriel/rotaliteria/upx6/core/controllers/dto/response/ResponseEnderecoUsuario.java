package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response;

import java.util.UUID;

public record ResponseEnderecoUsuario(
        UUID id,
        ResponseCep cep,
        Integer numero,
        String complemento,
        String referencia,
        Boolean principal
) {
}
