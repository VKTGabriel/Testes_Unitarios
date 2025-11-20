package br.dev.vktgabriel.rotaliteria.upx6.core.services;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestEnderecoUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.endereco.CepInfo;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.EnderecoUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.Usuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.repositories.EnderecoUsuarioRepository;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EnderecoUsuarioService {
    private final EnderecoUsuarioRepository enderecoUsuarioRepository;
    private final CepService cepService;



    public List<EnderecoUsuario> findAllbyUsuario(Usuario usuario) {
        return enderecoUsuarioRepository.findAllByUsuario(usuario);
    }

    public EnderecoUsuario findById(UUID id) throws RegistroNaoEncontradoException {
        EnderecoUsuario enderecoUsuario = enderecoUsuarioRepository.findById(id).orElse(null);
        if (enderecoUsuario == null) {
            throw new RegistroNaoEncontradoException("Endereco de Usuario", "id", id.toString());
        }
        return enderecoUsuario;
    }
}
