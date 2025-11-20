package br.com.rota_literaria.api_web_plataform.controller.dto.endereco;

import br.com.rota_literaria.api_web_plataform.model.endereco.Endereco;

public record EnderecoDTO(Integer numero,
                          String complemento,
                          String referencia,
                          Boolean isPrincipal) {

    public Endereco toEndereco() {
        Endereco endereco = new Endereco();
        endereco.setNumero(numero);
        return endereco;
    }
}