package br.newton.upx6.rota_literaria.exception.dto;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public record ErroRespostaDTO(Integer codigo, String status, String mensagem, List<CampoErroDTO> erros) {

    public static ErroRespostaDTO requisicaoInvalida(List<CampoErroDTO> erros) {
        String mensagem = String.format("Identifiquei %d campo&s invalido&s", erros.size())
                .replaceAll("&s", (erros.size() > 1) ? "s" : "");

        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        return new ErroRespostaDTO(status.value(), status.getReasonPhrase(), mensagem, erros);
    }
}
