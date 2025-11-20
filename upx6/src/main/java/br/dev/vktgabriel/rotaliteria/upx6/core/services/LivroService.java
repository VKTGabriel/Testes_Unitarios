package br.dev.vktgabriel.rotaliteria.upx6.core.services;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestLivro;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Livro;
import br.dev.vktgabriel.rotaliteria.upx6.core.repositories.LivroRepository;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers.LivroMapper;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroDuplicadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;
    private final LivroMapper livroMapper;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    @Transactional
    public Livro save(RequestLivro requestLivro) throws RegistroDuplicadoException {
        validar(requestLivro);
        return livroRepository.save(livroMapper.toEntity(requestLivro));
    }

    private void validar(RequestLivro requestLivro) throws RegistroDuplicadoException {
        Livro livro = livroRepository.findByIsbn(requestLivro.isbn()).orElse(null);
        if (livro != null) {
            throw new RegistroDuplicadoException("Livro", "isbn", requestLivro.isbn());
        }
    }
}
