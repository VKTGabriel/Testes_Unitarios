package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record RequestUsuario(
        @NotBlank(message = "Campo vazio ou nulo")
        @Size(max = 100)
        String nome,

        @NotBlank(message = "Campo vazio ou nulo")
        @Email
        String email,

        @NotBlank(message = "Campo vazio ou nulo")
        @Size(max = 50)
        String senha,

        @NotBlank(message = "Campo vazio ou nulo")
        @CPF
        String cpf
) {
}
