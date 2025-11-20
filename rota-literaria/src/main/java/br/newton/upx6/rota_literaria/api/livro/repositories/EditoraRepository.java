package br.newton.upx6.rota_literaria.api.livro.repositories;

import br.newton.upx6.rota_literaria.api.livro.entities.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EditoraRepository extends JpaRepository<Editora, UUID> {
}
