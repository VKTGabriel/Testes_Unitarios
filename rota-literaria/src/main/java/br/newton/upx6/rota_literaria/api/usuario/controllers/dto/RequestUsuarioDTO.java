package br.newton.upx6.rota_literaria.api.usuario.controllers.dto;

import br.newton.upx6.rota_literaria.validation.constrain.DataPassada;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public record RequestUsuarioDTO(
        @NotBlank(message = "Campo vazio ou nulo")
        @Size(max = 100, message = "Excedeu o limite de 100 caracteres")
        String nome,

        @NotBlank(message = "Campo vazio ou nulo")
        @Email(message = "E-mail inválido")
        String email,

        @NotBlank(message = "Campo vazio ou nulo")
        @Size(min = 8, max = 100, message = "A senha deve possuir entre 6 e 100 caracteres")
        String senha,

        @NotBlank(message = "Campo vazio ou nulo")
        @DataPassada
        String dataNascimento,

        @CPF(message = "Cpf inválido")
        String cpf) {
}