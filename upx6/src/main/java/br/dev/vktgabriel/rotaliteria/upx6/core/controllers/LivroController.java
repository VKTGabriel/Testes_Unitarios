package br.dev.vktgabriel.rotaliteria.upx6.core.controllers;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestLivro;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseLivro;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.interfaces.DAOController;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Livro;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.LivroService;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers.LivroMapper;
import br.dev.vktgabriel.rotaliteria.upx6.exception.RegistroDuplicadoException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@RequiredArgsConstructor
public class LivroController implements DAOController {
    private final LivroMapper livroMapper;
    private final LivroService livroService;

    @PostMapping
    public ResponseEntity<ResponseLivro> save(@RequestBody @Valid RequestLivro requestLivro) throws RegistroDuplicadoException {
        Livro livro = livroService.save(requestLivro);
        return ResponseEntity.created(getLocation(livro.getId())).body(livroMapper.ToResponse(livro));
    }

    @GetMapping
    public ResponseEntity<List<ResponseLivro>> findAll() {
        return ResponseEntity.ok(livroService.findAll().stream().map(livroMapper::ToResponse).toList());
    }
}
