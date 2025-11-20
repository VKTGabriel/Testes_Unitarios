package br.newton.upx6.rota_literaria.config.security.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

public class UsuarioAuthentication implements Authentication {
    private final IdentificadorUsuario identificadorUsuario;

    public UsuarioAuthentication(IdentificadorUsuario objetoIdentificadorUsuario) {
        if (objetoIdentificadorUsuario == null) {
            throw new ExceptionInInitializerError("Erro ao iniciar o UsuarioAuthentication sem um identificador válido");
        }
        this.identificadorUsuario = objetoIdentificadorUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.identificadorUsuario
                .getGrupos()
                .stream()
                .map(grupo -> new SimpleGrantedAuthority(grupo.getNome()))
                .collect(Collectors.toList());
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.identificadorUsuario;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        throw new IllegalArgumentException("Método desnecessário");
    }

    @Override
    public String getName() {
        return identificadorUsuario.getNome();
    }
}
