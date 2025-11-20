package br.newton.upx6.rota_literaria.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class MasterFilter extends OncePerRequestFilter {

    @Value("${variaveis.password.master}")
    private String senhaMaster;

    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("master-key");

        if (header != null && header.equals(senhaMaster)) {
            Authentication auth = new UsernamePasswordAuthenticationToken(
                    "Master",
                    null,
                    List.of(new SimpleGrantedAuthority("MASTER"))
            );

            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(auth);
        }


        filterChain.doFilter(request, response);
    }
}
