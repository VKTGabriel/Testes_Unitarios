package br.dev.vktgabriel.rotaliteria.upx6.core.controllers;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequesstGenero;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseGenero;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.interfaces.DAOController;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Genero;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.GeneroService;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers.GeneroMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livro/generos")
@RequiredArgsConstructor
public class GeneroController implements DAOController {
    private final GeneroService generoService;
    private final GeneroMapper generoMapper;

    @PostMapping
    public ResponseEntity<ResponseGenero> save(@Valid @RequestBody RequesstGenero requesstGenero) {
        Genero genero = generoService.save(requesstGenero);
        return ResponseEntity.created(getLocation(genero.getId())).body(generoMapper.toResponse(genero));
    }

    @GetMapping
    public ResponseEntity<List<ResponseGenero>> getAll() {
        return ResponseEntity.ok(generoService.getAll().stream().map(generoMapper::toResponse).toList());
    }

    @PatchMapping("/destaques")
    public ResponseEntity<List<ResponseGenero>> setDestaques(@RequestBody List<String> ids) {
        return ResponseEntity.ok(generoService.setListDestaque(ids).stream().map(generoMapper::toResponse).toList());
    }

    @GetMapping("/destaques")
    public ResponseEntity<List<ResponseGenero>> getDestaques() {
        return ResponseEntity.ok(generoService.getListDestaque().stream().map(generoMapper::toResponse).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseGenero> getById(@PathVariable String id) {
        return ResponseEntity.ok(generoMapper.toResponse(generoService.getById(id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        generoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
