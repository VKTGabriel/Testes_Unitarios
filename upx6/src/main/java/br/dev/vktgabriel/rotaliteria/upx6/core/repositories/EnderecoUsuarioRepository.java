package br.dev.vktgabriel.rotaliteria.upx6.core.repositories;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.EnderecoUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnderecoUsuarioRepository extends JpaRepository<EnderecoUsuario, UUID> {
    List<EnderecoUsuario> findAllByUsuario(Usuario usuario);
}
