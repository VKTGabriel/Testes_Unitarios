package br.newton.upx6.rota_literaria.api.usuario.repositories;

import br.newton.upx6.rota_literaria.api.usuario.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findUsuarioByEmail(String email);
}