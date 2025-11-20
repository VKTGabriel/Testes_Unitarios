package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response;

import java.util.UUID;

public record ResponseEnderecoBiblioteca(
        UUID id,
        ResponseCep cep,
        Integer numero
) {
}
