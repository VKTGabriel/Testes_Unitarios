package br.com.rota_literaria.api_web_plataform.repository.livro;

import br.com.rota_literaria.api_web_plataform.model.livro.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EditoraRepository extends JpaRepository<Editora, UUID> {
}
