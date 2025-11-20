package br.dev.vktgabriel.rotaliteria.upx6.core.controllers;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestEnderecoUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseDetailedUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseEnderecoUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.interfaces.DAOController;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.EnderecoUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.Usuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.EnderecoUsuarioService;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.UsuarioService;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers.UsuarioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
public class UsuarioController implements DAOController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;
    private final EnderecoUsuarioService enderecoUsuarioService;
    private final EnderecoUsuarioMapper enderecoUsuarioMapper;

    @PostMapping
    public ResponseEntity<ResponseUsuario> save(@RequestBody @Valid RequestUsuario usuarioDTO) {
        Usuario usuario = usuarioService.save(usuarioDTO);
        return ResponseEntity
                .created(getLocation(usuario.getId()))
                .body(usuarioMapper.toResponse(usuario));
    }

    @GetMapping
    public ResponseEntity<List<ResponseUsuario>> findAll() {
        List<ResponseUsuario> usuarios = usuarioService.findAll().stream().map(usuarioMapper::toResponse).toList();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDetailedUsuario> getById(@PathVariable UUID id) {
        ResponseDetailedUsuario usuario = usuarioMapper.toDetailedResponse(usuarioService.findById(id));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/{id}/enderecos")
    public ResponseEntity<ResponseEnderecoUsuario> addEndereco(@PathVariable UUID id, @RequestBody @Valid RequestEnderecoUsuario enderecoUsuarioDTO) {
        EnderecoUsuario enderecoUsuario = enderecoUsuarioService.save(usuarioService.findById(id), enderecoUsuarioDTO);
        return ResponseEntity
                .created(getLocation(enderecoUsuario.getId()))
                .body(enderecoUsuarioMapper.toResponse(enderecoUsuario));
    }

    @GetMapping("/{id}/enderecos")
    public ResponseEntity<List<ResponseEnderecoUsuario>> getEnderecos(@PathVariable UUID id) {
        List<ResponseEnderecoUsuario> enderecosUsuario = enderecoUsuarioService
                .findAllbyUsuario(usuarioService.findById(id))
                .stream()
                .map(enderecoUsuarioMapper::toResponse).toList();

        return ResponseEntity.ok(enderecosUsuario);
    }
}
