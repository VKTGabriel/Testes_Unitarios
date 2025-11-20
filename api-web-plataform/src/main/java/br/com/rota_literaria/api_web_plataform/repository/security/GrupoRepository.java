package br.com.rota_literaria.api_web_plataform.repository.security;

import br.com.rota_literaria.api_web_plataform.model.security.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GrupoRepository extends JpaRepository<Grupo, UUID> {
    Optional<Grupo> findByNome(String nome);
}
