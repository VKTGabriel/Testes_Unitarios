package br.newton.upx6.rota_literaria.api.usuario.services;

import br.newton.upx6.rota_literaria.api.usuario.repositories.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailRepository emailRepository;
}
