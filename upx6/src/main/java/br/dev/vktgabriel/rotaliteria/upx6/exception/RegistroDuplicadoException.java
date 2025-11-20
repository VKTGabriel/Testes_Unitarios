package br.dev.vktgabriel.rotaliteria.upx6.exception;

import br.dev.vktgabriel.rotaliteria.upx6.exception.components.CampoErro;
import lombok.Getter;

@Getter
public class RegistroDuplicadoException extends RuntimeException {
    private final CampoErro campoErro;

    public RegistroDuplicadoException(String registro, String campo, String valor) {
        super();
        String message = String.format("Já existe um registro de %s com esse(a) %s: %s", registro, campo, valor);
        this.campoErro = new CampoErro(campo, message);
    }
}
