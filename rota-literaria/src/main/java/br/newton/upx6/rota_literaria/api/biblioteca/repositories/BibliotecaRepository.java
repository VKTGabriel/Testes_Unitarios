package br.newton.upx6.rota_literaria.api.biblioteca.repositories;

import br.newton.upx6.rota_literaria.api.biblioteca.entities.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, UUID> {
}
