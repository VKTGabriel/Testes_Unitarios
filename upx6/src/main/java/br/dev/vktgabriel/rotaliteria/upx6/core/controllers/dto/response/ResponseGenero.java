package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response;

import java.util.UUID;

public record ResponseGenero(
        UUID id,
        String nome,
        Boolean destaque
) {
}
