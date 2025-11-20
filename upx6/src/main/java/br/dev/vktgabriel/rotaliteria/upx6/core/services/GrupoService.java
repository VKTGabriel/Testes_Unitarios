package br.dev.vktgabriel.rotaliteria.upx6.core.services;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestGrupo;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.Grupo;
import br.dev.vktgabriel.rotaliteria.upx6.core.repositories.GrupoRepository;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers.GrupoMapper;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroDuplicadoException;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoService {
    private final GrupoRepository grupoRepository;
    private final GrupoMapper grupoMapper;

    public List<Grupo> getAll() {
        return grupoRepository.findAll();
    }

    public Grupo findByNome(String nome) throws RegistroNaoEncontradoException {
        Grupo grupo = grupoRepository.findByNome(nome.toUpperCase()).orElse(null);
        if (grupo == null) {
            throw new RegistroNaoEncontradoException("Grupo", "nome", nome);
        }
        return grupo;
    }

    public Grupo save(RequestGrupo grupoDTO) {
        validar(grupoDTO);
        return grupoRepository.save(grupoMapper.toEntity(grupoDTO));
    }

    private void validar(RequestGrupo requestGrupo) throws RegistroDuplicadoException {
        Grupo grupo = grupoRepository.findByNome(requestGrupo.nome().toUpperCase()).orElse(null);
        if (grupo != null) {
            throw new RegistroDuplicadoException("Grupo", "nome", requestGrupo.nome());
        }
    }
}
