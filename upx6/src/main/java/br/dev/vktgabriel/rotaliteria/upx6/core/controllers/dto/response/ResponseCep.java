package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response;

public record ResponseCep(
        String cep,
        String uf,
        String estado,
        String localidade,
        String bairro,
        String logradouro) {

}
