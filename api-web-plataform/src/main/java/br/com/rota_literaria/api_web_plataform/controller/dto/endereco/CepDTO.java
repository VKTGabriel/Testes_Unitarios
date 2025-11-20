package br.com.rota_literaria.api_web_plataform.controller.dto.endereco;

import java.util.function.IntPredicate;

public record CepDTO(String cep) {

    private String formatarCep() {
        IntPredicate isNumero = e -> e > 47 && e < 58;

        return new StringBuilder(cep)
                .chars()
                .filter(isNumero)
                .map(Character::getNumericValue)
                .mapToObj(String::valueOf)
                .reduce("", (ac, letra) ->  ac + letra);
    }

    public String obterCepFormatado() throws RuntimeException {
        String formatado = formatarCep();
        if (formatado.length() != 8) {
            throw new RuntimeException("O Cep informado está em um formato inválido");
        }

        return formatado;
    }
}