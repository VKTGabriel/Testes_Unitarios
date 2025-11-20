package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request;

import br.dev.vktgabriel.rotaliteria.upx6.validation.constrain.Booleano;
import br.dev.vktgabriel.rotaliteria.upx6.validation.constrain.CEP;
import br.dev.vktgabriel.rotaliteria.upx6.validation.constrain.NumericoPositivo;
import jakarta.validation.constraints.NotBlank;

public record RequestEnderecoUsuario(
        RequestEndereco requestEndereco,

        @NotBlank
        @Booleano
        String principal
) {
}
