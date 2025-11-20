package br.com.rota_literaria.api_web_plataform.controller.security;

import br.com.rota_literaria.api_web_plataform.controller.dto.security.RequestAutoridadeDTO;
import br.com.rota_literaria.api_web_plataform.controller.dto.security.ResponseAutoridadeDTO;
import br.com.rota_literaria.api_web_plataform.model.security.Autoridade;
import br.com.rota_literaria.api_web_plataform.service.security.AutoridadeService;
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
@RequestMapping("security/autoridades")
@RequiredArgsConstructor
public class AutoridadeController {

    private final AutoridadeService autoridadeService;

    @PostMapping
    @PreAuthorize("hasRole('MASTER')")
    public ResponseEntity<Object> addAutoridade(@RequestBody RequestAutoridadeDTO autoridadeDTO) {
        try {
            Autoridade autoridade = autoridadeService.save(autoridadeDTO);

            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(autoridade.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(autoridadeService.getResponseDTO(autoridade));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping
    @PreAuthorize("hasRole('MASTER')")
    public ResponseEntity<List<ResponseAutoridadeDTO>> getAllAutoridades() {
        List<Autoridade> lista = autoridadeService.findAll();
        return ResponseEntity.ok(autoridadeService.convertResponseDTOList(lista));
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('MASTER')")
    public ResponseEntity<Object> getAutoridadeById(@PathVariable("id") UUID id) {
        try {
            return ResponseEntity.ok(autoridadeService.getResponseDTO(autoridadeService.findById(id)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('MASTER')")
    public ResponseEntity<Object> updateAutoridade(@PathVariable("id") UUID id, @RequestBody RequestAutoridadeDTO autoridadeDTO) {
        try {
            return ResponseEntity.ok(autoridadeService.getResponseDTO(autoridadeService.update(id, autoridadeDTO)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('MASTER')")
    public ResponseEntity<Object> deleteAutoridade(@PathVariable("id") UUID id) {
        try {
            autoridadeService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
