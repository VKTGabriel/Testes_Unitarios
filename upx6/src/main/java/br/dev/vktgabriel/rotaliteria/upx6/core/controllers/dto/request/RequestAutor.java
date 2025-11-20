package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RequestAutor(
        @NotBlank(message = "Campo vazio ou nulo")
        String nome,

        @NotBlank(message = "Campo vazio ou nulo")
        String nacionalidade
) {
}
