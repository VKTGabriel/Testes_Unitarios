package br.com.rota_literaria.api_web_plataform.service.usuario;

import br.com.rota_literaria.api_web_plataform.model.usuario.Usuario;
import br.com.rota_literaria.api_web_plataform.repository.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

}
