package br.dev.vktgabriel.rotaliteria.upx6.exception.components;

import org.springframework.http.HttpStatus;

import java.util.List;

public record RespostaErro(Integer codigo, String status, String mensagem, List<CampoErro> dados) {
    public static RespostaErro unprocessableEntity(List<CampoErro> dados) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        String mensagem = String.format("Identifiquei %d campo&s invalido&s", dados.size())
                .replaceAll("&s", (dados.size() > 1) ? "s" : "");

        return new RespostaErro(status.value(), status.getReasonPhrase(), mensagem, dados);
    }

    public static RespostaErro conflict(CampoErro campoErro) {
        HttpStatus status = HttpStatus.CONFLICT;
        return new RespostaErro(status.value(), status.getReasonPhrase(), "Registro Duplicado", List.of(campoErro));
    }

    public static RespostaErro not_found(CampoErro campoErro) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new RespostaErro(status.value(), status.getReasonPhrase(), "Registro Não Encontrado", List.of(campoErro));
    }
}
