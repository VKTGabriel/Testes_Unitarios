package br.dev.vktgabriel.rotaliteria.upx6.core.controllers;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestGrupo;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseGrupo;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.interfaces.DAOController;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.Grupo;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.GrupoService;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers.GrupoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/grupos")
@RequiredArgsConstructor
public class GrupoController implements DAOController {
    private final GrupoService grupoService;
    private final GrupoMapper grupoMapper;

    @GetMapping
    public ResponseEntity<List<ResponseGrupo>> getAll() {
        return ResponseEntity.ok(grupoService.getAll().stream().map(grupoMapper::toResponse).toList());
    }

    @PostMapping
    public ResponseEntity<ResponseGrupo> save(@RequestBody @Valid RequestGrupo grupoDTO) {
        Grupo grupo =grupoService.save(grupoDTO);
        return ResponseEntity
                .created(getLocation(grupo.getId()))
                .body(grupoMapper.toResponse(grupo));
    }
}