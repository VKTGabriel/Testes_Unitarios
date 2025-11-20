package br.dev.vktgabriel.rotaliteria.upx6.core.repositories;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Autor;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GeneroRepository extends JpaRepository<Genero, UUID> {
    Optional<Genero> findByNome(String nome);
    List<Genero> findAllByIsDestaque(Boolean destaque);
}
