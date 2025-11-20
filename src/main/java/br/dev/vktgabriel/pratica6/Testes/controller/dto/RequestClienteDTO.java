package br.dev.vktgabriel.pratica6.Testes.controller.dto;

import br.dev.vktgabriel.pratica6.Testes.validation.DataPassada;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RequestClienteDTO(
        @NotBlank(message = "Campo nulo ou vazio")
        String nome,

        @NotBlank(message = "Campo nulo ou vazio")
        @Email
        String email,

        @NotBlank(message = "Campo nulo ou vazio")
        @DataPassada
        String dataNascimento
) {
}
