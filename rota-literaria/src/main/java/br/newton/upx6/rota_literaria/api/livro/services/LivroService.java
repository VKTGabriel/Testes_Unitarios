package br.newton.upx6.rota_literaria.api.livro.services;

import br.newton.upx6.rota_literaria.api.livro.dto.LivroDTO;
import br.newton.upx6.rota_literaria.api.livro.entities.Livro;
import br.newton.upx6.rota_literaria.api.livro.repositories.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

}
