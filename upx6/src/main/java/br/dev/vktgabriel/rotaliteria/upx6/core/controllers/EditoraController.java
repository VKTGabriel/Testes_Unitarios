package br.dev.vktgabriel.rotaliteria.upx6.core.controllers;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestEditora;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseEditora;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.interfaces.DAOController;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Editora;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.EditoraService;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers.EditoraMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livro/editoras")
@RequiredArgsConstructor
public class EditoraController implements DAOController {
    private final EditoraService editoraService;
    private final EditoraMapper editoraMapper;

    @PostMapping
    public ResponseEntity<ResponseEditora> save(@Valid @RequestBody RequestEditora requestEditora) {
        Editora editora = editoraService.save(requestEditora);
        return ResponseEntity.created(getLocation(editora.getId())).body(editoraMapper.toResponse(editora));
    }

    @GetMapping()
    public ResponseEntity<List<ResponseEditora>> getAll() {
        return ResponseEntity.ok(editoraService.getAll().stream().map(editoraMapper::toResponse).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseEditora> getById(@PathVariable String id) {
        return ResponseEntity.ok(editoraMapper.toResponse(editoraService.getById(id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        editoraService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
