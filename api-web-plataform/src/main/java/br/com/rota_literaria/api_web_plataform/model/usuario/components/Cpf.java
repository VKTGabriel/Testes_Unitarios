package br.com.rota_literaria.api_web_plataform.model.usuario.components;

import lombok.Getter;

@Getter
public class Cpf {
    private final String cpf;

    public Cpf(String cpf) throws IllegalArgumentException {
        if(!validar(cpf)) {
            throw new IllegalArgumentException("CPF invalido");
        }

        this.cpf = cpf;
    }

    private static boolean validar(String cpf) {
        return true;
    }
}
