package br.newton.upx6.rota_literaria.config.security.security;

import br.newton.upx6.rota_literaria.api.usuario.entities.Usuario;
import br.newton.upx6.rota_literaria.api.usuario.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioAuthenticationProvider implements AuthenticationProvider {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getName();
        String senha = authentication.getCredentials().toString();

        Optional<Usuario> usuarioOptional = usuarioRepository.findUsuarioByEmail(email);

        if (usuarioOptional.isEmpty()) {
            return null;
        }

        Usuario usuario = usuarioOptional.get();

        if (passwordEncoder.matches(senha, usuario.getSenha())) {
            IdentificadorUsuario identificadorUsuario =  new IdentificadorUsuario(
                    usuario.getId(),
                    usuario.getNome(),
                    usuario.getEmail(),
                    usuario.getCpf(),
                    List.of(usuario.getGrupo())
            );

            return new UsuarioAuthentication(identificadorUsuario);
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
