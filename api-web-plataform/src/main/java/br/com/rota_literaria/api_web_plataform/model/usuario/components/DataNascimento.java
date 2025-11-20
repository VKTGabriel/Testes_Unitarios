package br.com.rota_literaria.api_web_plataform.model.usuario.components;

import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
public class DataNascimento {
    private final LocalDate dataNascimento;

    public DataNascimento(LocalDate dataNascimento) throws IllegalArgumentException {
        if(!validar(dataNascimento)) {
            throw new IllegalArgumentException("Data de Nascimento Inválida");
        }
        this.dataNascimento = dataNascimento;
    }

    private static boolean validar(LocalDate dataNascimento) {
        return true;
    }

    public String toString() {
        return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
