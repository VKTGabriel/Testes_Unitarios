package br.dev.vktgabriel.rotaliteria.upx6.core.repositories;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EditoraRepository extends JpaRepository<Editora, UUID> {
    Optional<Editora> findByNome(String nome);
}
