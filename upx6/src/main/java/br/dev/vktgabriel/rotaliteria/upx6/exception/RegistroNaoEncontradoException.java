package br.dev.vktgabriel.rotaliteria.upx6.exception;

import br.dev.vktgabriel.rotaliteria.upx6.exception.components.CampoErro;
import lombok.Getter;

@Getter
public class RegistroNaoEncontradoException extends RuntimeException {
    private final CampoErro campoErro;

    public RegistroNaoEncontradoException(String registro, String campo, String valor) {
        super();
        String message = String.format("Não foi possivel localizar um registro de %s com esse(a) %s: %s", registro, campo, valor);
        this.campoErro = new CampoErro(campo, message);
    }
}
