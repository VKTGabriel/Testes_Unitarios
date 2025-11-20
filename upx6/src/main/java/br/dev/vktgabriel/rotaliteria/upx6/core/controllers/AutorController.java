package br.dev.vktgabriel.rotaliteria.upx6.core.controllers;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestAutor;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseAutor;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.interfaces.DAOController;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Autor;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.AutorService;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers.AutorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro/autores")
@RequiredArgsConstructor
public class AutorController implements DAOController {
    private final AutorService autorService;
    private final AutorMapper autorMapper;

    @PostMapping
    public ResponseEntity<ResponseAutor> save(@Valid @RequestBody RequestAutor requestAutor) {
        Autor autor = autorService.save(requestAutor);
        return ResponseEntity.created(getLocation(autor.getId())).body(autorMapper.toResponse(autor));
    };

    @GetMapping
    public ResponseEntity<List<ResponseAutor>> findAll() {
        return ResponseEntity.ok(autorService.findAll().stream().map(autorMapper::toResponse).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseAutor> findById(@PathVariable String id) {
        return ResponseEntity.ok(autorMapper.toResponse(autorService.getById(id)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseAutor> update(@PathVariable String id, @RequestBody RequestAutor requestAutor) {
        return ResponseEntity.ok(autorMapper.toResponse(autorService.update(id, requestAutor)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        autorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}