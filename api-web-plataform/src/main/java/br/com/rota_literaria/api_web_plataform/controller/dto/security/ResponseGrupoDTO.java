package br.com.rota_literaria.api_web_plataform.controller.dto.security;

import br.com.rota_literaria.api_web_plataform.model.security.Autoridade;

import java.util.List;
import java.util.UUID;

public record ResponseGrupoDTO(UUID id, String nome, List<ResponseAutoridadeDTO> autoridades) {
}
