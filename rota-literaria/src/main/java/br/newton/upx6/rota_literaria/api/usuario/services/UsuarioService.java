package br.newton.upx6.rota_literaria.api.usuario.services;

import br.newton.upx6.rota_literaria.api.usuario.controllers.dto.RequestUsuarioDTO;
import br.newton.upx6.rota_literaria.api.usuario.entities.Usuario;
import br.newton.upx6.rota_literaria.api.usuario.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EmailService emailService;
    private final TelefoneService telefoneService;

    public Usuario salvar(RequestUsuarioDTO requestUsuarioDTO) {


        return new Usuario();
    }
}
