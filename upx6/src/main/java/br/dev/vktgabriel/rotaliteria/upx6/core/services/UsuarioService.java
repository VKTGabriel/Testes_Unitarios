package br.dev.vktgabriel.rotaliteria.upx6.core.services;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.Usuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.repositories.UsuarioRepository;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers.UsuarioMapper;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroDuplicadoException;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final GrupoService grupoService;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(UUID id) throws RegistroNaoEncontradoException {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            throw new RegistroNaoEncontradoException("Usuario", "id", id.toString());
        }
        return usuario;
    }

    @Transactional
    public Usuario save(RequestUsuario usuarioDTO) throws RegistroDuplicadoException {
        validar(usuarioDTO);
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setGrupo(grupoService.findByNome("usuario"));
        return usuarioRepository.save(usuario);
    }

    private void validar(RequestUsuario usuarioDTO) throws RegistroDuplicadoException {
        Usuario usuario = usuarioRepository.findByEmail(usuarioDTO.email()).orElse(null);
        if (usuario != null) {
            throw new RegistroDuplicadoException("Usuario", "email", usuarioDTO.email());
        }

        usuario = usuarioRepository.findByCpf(usuarioDTO.cpf()).orElse(null);
        if (usuario != null) {
            throw new RegistroDuplicadoException("Usuario", "cpf", usuarioDTO.cpf());
        }
    }
}
