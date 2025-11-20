package br.dev.vktgabriel.rotaliteria.upx6.core.repositories;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByCpf(String cpf);
}
