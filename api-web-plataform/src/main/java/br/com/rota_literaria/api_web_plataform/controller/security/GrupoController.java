package br.com.rota_literaria.api_web_plataform.controller.security;

import br.com.rota_literaria.api_web_plataform.controller.dto.security.RequestGrupoDTO;
import br.com.rota_literaria.api_web_plataform.controller.dto.security.ResponseGrupoDTO;
import br.com.rota_literaria.api_web_plataform.model.security.Grupo;
import br.com.rota_literaria.api_web_plataform.service.security.GrupoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("security/grupos")
@RequiredArgsConstructor
public class GrupoController {

    private final GrupoService grupoService;

    @PostMapping
    @PreAuthorize("hasRole('MASTER')")
    public ResponseEntity<Object> grupo(@RequestBody RequestGrupoDTO grupoDTO) {
        try {
            Grupo salvo = grupoService.save(grupoDTO);

            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(salvo.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(grupoService.getResponseDTO(salvo));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping
    @PreAuthorize("hasRole('MASTER')")
    public ResponseEntity<List<ResponseGrupoDTO>> getGrupos() {
        List<Grupo> grupos = grupoService.getAllGrupos();
        return ResponseEntity.ok(grupoService.convertResponseDTOList(grupos));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('MASTER')")
    public ResponseEntity<ResponseGrupoDTO> getGrupo(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(grupoService.getResponseDTO(grupoService.findById(id)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MASTER')")
    @Transactional
    public ResponseEntity<Object> updateGrupo(@PathVariable UUID id, @RequestBody RequestGrupoDTO grupoDTO) {
        try {
            return ResponseEntity.ok(grupoService.getResponseDTO(grupoService.update(id, grupoDTO)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MASTER')")
    public ResponseEntity<Object> deleteGrupo(@PathVariable UUID id) {
        try {
            grupoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}