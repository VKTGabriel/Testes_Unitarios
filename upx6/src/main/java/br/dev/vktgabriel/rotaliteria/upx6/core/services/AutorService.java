package br.dev.vktgabriel.rotaliteria.upx6.core.services;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestAutor;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Autor;
import br.dev.vktgabriel.rotaliteria.upx6.core.repositories.AutorRepository;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers.AutorMapper;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroDuplicadoException;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AutorService {
    private final AutorRepository autorRepository;
    public final AutorMapper autorMapper;

    @Transactional
    public Autor save(RequestAutor requestAutor) throws RegistroDuplicadoException {
        validar(requestAutor);
        return autorRepository.save(autorMapper.toEntity(requestAutor));
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Autor getById(String id) throws RegistroNaoEncontradoException {
        UUID uuid = UUID.fromString(id);
        Autor autor = autorRepository.findById(uuid).orElse(null);
        if (autor == null) {
            throw new RegistroNaoEncontradoException("Autor", "id", id);
        }
        return autor;
    }

    @Transactional
    public Autor update(String id, RequestAutor requestAutor) throws RegistroNaoEncontradoException {
        Autor autor = getById(id);
        validarUpdate(requestAutor, autor.getId());
        autor.setNome(requestAutor.nome());
        autor.setNacionalidade(requestAutor.nacionalidade());
        return autorRepository.save(autor);
    }

    @Transactional
    public void delete(String id) throws RegistroNaoEncontradoException {
        Autor autor = getById(id);
        autorRepository.delete(autor);
    }

    private void validar(RequestAutor requestAutor) throws RegistroDuplicadoException {
        Autor autor = autorRepository.findByNome(requestAutor.nome()).orElse(null);
        if (autor != null) {
            throw new RegistroDuplicadoException("Autor", "nome", requestAutor.nome());
        }
    }

    private void validarUpdate(RequestAutor requestAutor, UUID id) throws RegistroDuplicadoException {
        Autor autor = autorRepository.findByNomeAndIdNot(requestAutor.nome(), id).orElse(null);
        if (autor != null) {
            throw new RegistroDuplicadoException("Autor", "nome", requestAutor.nome());
        }
    }
}