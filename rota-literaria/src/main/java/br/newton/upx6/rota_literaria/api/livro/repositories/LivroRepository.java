package br.newton.upx6.rota_literaria.api.livro.repositories;

import br.newton.upx6.rota_literaria.api.livro.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
