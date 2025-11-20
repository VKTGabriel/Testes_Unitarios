package br.newton.upx6.rota_literaria.api.livro.repositories;

import br.newton.upx6.rota_literaria.api.livro.entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GeneroRepository extends JpaRepository<Genero, UUID> {
}
