package br.dev.vktgabriel.rotaliteria.upx6.core.services;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestEditora;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Editora;
import br.dev.vktgabriel.rotaliteria.upx6.core.repositories.EditoraRepository;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers.EditoraMapper;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroDuplicadoException;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditoraService {
    private final EditoraRepository editoraRepository;
    private final EditoraMapper editoraMapper;

    @Transactional
    public Editora save (RequestEditora requestEditora) {
        validar(requestEditora);
        return editoraRepository.save(editoraMapper.toEntity(requestEditora));
    }

    public Editora getById(String id) throws RegistroNaoEncontradoException {
        UUID uuid = UUID.fromString(id);
        Editora editora = editoraRepository.findById(uuid).orElse(null);
        if (editora == null) {
            throw new RegistroNaoEncontradoException("Editora", "id", id);
        }
        return editora;
    }

    public List<Editora> getAll() {
        return editoraRepository.findAll();
    }

    public void delete(String id) throws RegistroNaoEncontradoException {
        Editora editora = getById(id);
        editoraRepository.delete(editora);
    }

    private void validar(RequestEditora requestEditora) throws RegistroDuplicadoException {
        Editora editora = editoraRepository.findByNome(requestEditora.nome()).orElse(null);
        if (editora != null) {
            throw new RegistroDuplicadoException("Editora", "nome", requestEditora.nome());
        }
    }
}