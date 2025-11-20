package br.com.rota_literaria.api_web_plataform.repository.security;

import br.com.rota_literaria.api_web_plataform.model.security.Autoridade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AutoridadeRepository extends JpaRepository<Autoridade, UUID> {
    Optional<Autoridade> findByNome(String nome);
}
