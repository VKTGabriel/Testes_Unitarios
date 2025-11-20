package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

public record RequestBiblioteca(
        @NotBlank(message = "Campo vazio ou nulo")
        String nome,

        @CNPJ
        String cnpj,

        @NotNull(message = "O Campo endereço é obrigatório para o cadastro de uma bilioteca")
        @Valid
        RequestEndereco endereco
) {
}
