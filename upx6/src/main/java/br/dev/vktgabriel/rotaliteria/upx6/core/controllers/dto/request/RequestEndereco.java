package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request;

import br.dev.vktgabriel.rotaliteria.upx6.validation.constrain.CEP;
import br.dev.vktgabriel.rotaliteria.upx6.validation.constrain.NumericoPositivo;
import jakarta.validation.constraints.NotBlank;

public record RequestEndereco(
        @NotBlank(message = "Campo vazio ou nulo")
        @CEP
        String cep,

        @NotBlank(message = "Campo vazio ou nulo")
        @NumericoPositivo
        String numero
) {
}
