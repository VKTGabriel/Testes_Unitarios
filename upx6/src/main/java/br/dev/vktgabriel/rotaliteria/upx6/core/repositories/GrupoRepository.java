package br.dev.vktgabriel.rotaliteria.upx6.core.repositories;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GrupoRepository extends JpaRepository<Grupo, UUID> {
    Optional<Grupo> findByNome(String nome);
}
