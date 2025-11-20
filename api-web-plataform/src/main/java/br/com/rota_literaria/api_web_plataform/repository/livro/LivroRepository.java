package br.com.rota_literaria.api_web_plataform.repository.livro;

import br.com.rota_literaria.api_web_plataform.model.livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
