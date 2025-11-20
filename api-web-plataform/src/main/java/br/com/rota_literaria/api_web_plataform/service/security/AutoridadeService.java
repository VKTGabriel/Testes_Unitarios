package br.com.rota_literaria.api_web_plataform.service.security;

import br.com.rota_literaria.api_web_plataform.controller.dto.security.RequestAutoridadeDTO;
import br.com.rota_literaria.api_web_plataform.controller.dto.security.RequestGrupoDTO;
import br.com.rota_literaria.api_web_plataform.controller.dto.security.ResponseAutoridadeDTO;
import br.com.rota_literaria.api_web_plataform.model.security.Autoridade;
import br.com.rota_literaria.api_web_plataform.repository.security.AutoridadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AutoridadeService {

    private final AutoridadeRepository autoridadeRepository;

    public Autoridade save(RequestAutoridadeDTO autoridadeDTO) throws IllegalArgumentException {
        Optional<Autoridade> optionalAutoridade = autoridadeRepository.findByNome(autoridadeDTO.nome());

        if (optionalAutoridade.isPresent()) {
            throw new IllegalArgumentException(String.format("Autoridade %s existente", autoridadeDTO.nome()));
        }

        Autoridade autoridade = new Autoridade();
        autoridade.setNome(autoridadeDTO.nome());

        return autoridadeRepository.save(autoridade);
    }

    public ResponseAutoridadeDTO getResponseDTO(Autoridade autoridade) {
        return new ResponseAutoridadeDTO(autoridade.getId(),autoridade.getNome());
    }

    public List<ResponseAutoridadeDTO> convertResponseDTOList(List<Autoridade> autoridadeList) {
        return autoridadeList.stream().map(this::getResponseDTO).toList();
    }

    public List<Autoridade> findAll() {
        return autoridadeRepository.findAll();
    }

    public Autoridade findById(UUID id) throws IllegalArgumentException {
        Optional<Autoridade> optionalAutoridade = autoridadeRepository.findById(id);
        if (optionalAutoridade.isEmpty()) {
            throw new IllegalArgumentException(String.format("Autoridade %s não encontrada", id));
        }
        return optionalAutoridade.get();
    }

    public List<Autoridade> findById(List<UUID> listaID){
        return autoridadeRepository.findAllById(listaID);
    }

    public List<Autoridade> findById(RequestGrupoDTO grupoDTO) {
        return findById(grupoDTO.autoridades());
    }

    public Autoridade update(UUID id, RequestAutoridadeDTO autoridadeDTO) throws IllegalArgumentException {
        try {
            Autoridade autoridade = findById(id);
            autoridade.setNome(autoridadeDTO.nome());
            return autoridadeRepository.save(autoridade);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("Autoridade %s não encontrada", id));
        }
    }

    public void deleteById(UUID id) throws IllegalArgumentException {
        try {
            Autoridade autoridade = findById(id);
            autoridadeRepository.delete(autoridade);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format("Autoridade %s não encontrada", id));
        }
    }
}
