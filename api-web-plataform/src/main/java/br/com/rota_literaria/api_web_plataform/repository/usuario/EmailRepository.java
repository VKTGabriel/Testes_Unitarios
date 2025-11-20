package br.com.rota_literaria.api_web_plataform.repository.usuario;

import br.com.rota_literaria.api_web_plataform.model.usuario.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {
}
