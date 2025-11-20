package br.com.rota_literaria.api_web_plataform.controller.dto.erro;

import org.springframework.http.HttpStatus;

import java.util.List;

public record RespostaErro(Integer status, String mensagem, List<ErroCampo> campos) {

    public static RespostaErro padrao(String mensagem) {
        return new RespostaErro(HttpStatus.BAD_REQUEST.value(), mensagem, List.of());
    }

    public static RespostaErro conflito(String mensagem) {
        return new RespostaErro(HttpStatus.CONFLICT.value(), mensagem, List.of());
    }
}
