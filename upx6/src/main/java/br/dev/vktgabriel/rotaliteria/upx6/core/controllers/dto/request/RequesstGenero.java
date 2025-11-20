package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request;

import br.dev.vktgabriel.rotaliteria.upx6.validation.constrain.Booleano;
import jakarta.validation.constraints.NotBlank;

public record RequesstGenero(
        @NotBlank(message = "Campo vazio ou nulo")
        String nome,

        @NotBlank(message = "Campo vazio ou nulo")
        @Booleano
        String destaque
) {
}
