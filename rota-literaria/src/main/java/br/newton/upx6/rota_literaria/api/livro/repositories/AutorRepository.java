package br.newton.upx6.rota_literaria.api.livro.repositories;

import br.newton.upx6.rota_literaria.api.livro.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
