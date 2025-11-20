package br.com.rota_literaria.api_web_plataform.controller.dto.security;

import java.util.List;
import java.util.UUID;

public record RequestGrupoDTO(String nome, List<UUID> autoridades) {
}
