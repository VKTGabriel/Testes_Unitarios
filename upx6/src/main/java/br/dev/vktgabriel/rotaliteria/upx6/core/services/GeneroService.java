package br.dev.vktgabriel.rotaliteria.upx6.core.services;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequesstGenero;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Genero;
import br.dev.vktgabriel.rotaliteria.upx6.core.repositories.GeneroRepository;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers.GeneroMapper;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroDuplicadoException;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GeneroService {
    private final GeneroRepository generoRepository;
    private final GeneroMapper generoMapper;

    @Transactional
    public Genero save(RequesstGenero requesstGenero) {
        validar(requesstGenero);
        return generoRepository.save(generoMapper.toEntity(requesstGenero));
    }

    public List<Genero> getAll() {
        return generoRepository.findAll();
    }

    public Genero getById(String id) {
        UUID uuid = UUID.fromString(id);
        Genero genero = generoRepository.findById(uuid).orElse(null);
        if (genero == null) {
            throw new RegistroNaoEncontradoException("Genero", "id", id);
        }
        return genero;
    }

    public List<Genero> getListById(List<String> ids) {
        return ids.stream().map(this::getById).toList();
    }

    public List<Genero> getListDestaque() {
        return generoRepository.findAllByIsDestaque(true);
    }

    @Transactional
    public List<Genero> setListDestaque(List<String> ids) {
        getListDestaque().forEach(genero -> {
            genero.setIsDestaque(false);
            generoRepository.save(genero);
        });

        return ids.stream().map(this::getById).map(genero -> {
            genero.setIsDestaque(true);
            return generoRepository.save(genero);
        }).toList();
    }

    @Transactional
    public void delete(String id) throws RegistroNaoEncontradoException {
        Genero genero = getById(id);
        generoRepository.delete(genero);
    }

    private void validar(RequesstGenero requesstGenero) {
        Genero genero = generoRepository.findByNome(requesstGenero.nome()).orElse(null);
        if (genero != null) {
            throw new RegistroDuplicadoException("Genero", "nome", requesstGenero.nome());
        }
    }
}