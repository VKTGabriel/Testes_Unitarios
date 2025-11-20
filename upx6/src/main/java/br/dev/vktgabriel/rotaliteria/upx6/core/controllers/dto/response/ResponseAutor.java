package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response;

import java.util.UUID;

public record ResponseAutor(
        UUID id,
        String nome,
        String nacionalidade
) {
}
