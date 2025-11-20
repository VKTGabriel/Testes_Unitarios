package br.com.rota_literaria.api_web_plataform.service.security;

import br.com.rota_literaria.api_web_plataform.controller.dto.security.RequestGrupoDTO;
import br.com.rota_literaria.api_web_plataform.controller.dto.security.ResponseGrupoDTO;
import br.com.rota_literaria.api_web_plataform.model.security.Autoridade;
import br.com.rota_literaria.api_web_plataform.model.security.Grupo;
import br.com.rota_literaria.api_web_plataform.repository.security.AutoridadeRepository;
import br.com.rota_literaria.api_web_plataform.repository.security.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository grupoRepository;
    private final AutoridadeRepository autoridadeRepository;
    private final AutoridadeService autoridadeService;

    public Grupo save(RequestGrupoDTO grupoDTO) throws IllegalArgumentException {
        Optional<Grupo> grupoOptional = grupoRepository.findByNome(grupoDTO.nome());

        if (grupoOptional.isPresent()) {
            throw new IllegalArgumentException(String.format("Grupo %s cadastrado", grupoDTO.nome()));
        }

        List<Autoridade> autoridades = autoridadeService.findById(grupoDTO);

        Grupo grupo = new Grupo();
        grupo.setNome(grupoDTO.nome());
        grupo.setAutorizacoes(autoridades);

        return grupoRepository.save(grupo);
    }

    public ResponseGrupoDTO getResponseDTO(Grupo grupo) {
        return new ResponseGrupoDTO(grupo.getId(), grupo.getNome(), autoridadeService.convertResponseDTOList(grupo.getAutorizacoes()));
    }

    public List<ResponseGrupoDTO> convertResponseDTOList(List<Grupo> grupos) {
        return grupos.stream().map(this::getResponseDTO).toList();
    }

    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    public Grupo findById(UUID id) throws IllegalArgumentException {
        Optional<Grupo> grupoOptional = grupoRepository.findById(id);
        if (grupoOptional.isEmpty()) {
            throw new IllegalArgumentException(String.format("Grupo %s não encontrada", id));
        }
        return grupoOptional.get();
    }

    @Transactional
    public Grupo update(UUID id, RequestGrupoDTO grupoDTO) throws IllegalArgumentException {
        Optional<Grupo> grupoOptional = grupoRepository.findById(id);
        if (grupoOptional.isEmpty()) {
            throw new IllegalArgumentException(String.format("Grupo %s não encontrada", id));
        }
        Grupo grupo = grupoOptional.get();
        grupo.setNome(grupoDTO.nome());
        grupo.setAutorizacoes(autoridadeService.findById(grupoDTO));
        return grupoRepository.save(grupo);
    }

    public void delete(UUID id) throws IllegalArgumentException {
        Optional<Grupo> grupoOptional = grupoRepository.findById(id);
        if (grupoOptional.isEmpty()) {
            throw new IllegalArgumentException(String.format("Grupo %s não encontrada", id));
        }
        grupoRepository.delete(grupoOptional.get());
    }
}
