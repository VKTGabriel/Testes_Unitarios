package br.com.rota_literaria.api_web_plataform.model.usuario.components;

import org.springframework.security.crypto.password.PasswordEncoder;

public class Senha {
    private final String senha;

    public Senha(String senha) throws IllegalArgumentException {
        if (!validar(senha)) {
            throw new IllegalArgumentException("Senha Invalida");
        }

        this.senha = senha;
    }

    private static boolean validar(String senha) {
        return true;
    }

    public String obterSenhaCriptografada(PasswordEncoder passwordEncoder) {
        return passwordEncoder.encode(senha);
    }
}
