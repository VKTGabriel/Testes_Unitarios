package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestGrupo(
        @NotBlank(message = "Campo vazio ou nulo")
        @Size(max = 50, message = "O Grupo deve ter no máximo 50 caracteres")
        String nome
) {
}
