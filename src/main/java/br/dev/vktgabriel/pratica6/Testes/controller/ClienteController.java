package br.dev.vktgabriel.pratica6.Testes.controller;

import br.dev.vktgabriel.pratica6.Testes.controller.dto.RequestClienteDTO;
import br.dev.vktgabriel.pratica6.Testes.controller.interfaces.DaoController;
import br.dev.vktgabriel.pratica6.Testes.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
public class ClienteController implements DaoController {
    @PostMapping
    public ResponseEntity<Cliente> salvar(RequestClienteDTO clienteDTO) {
        return ResponseEntity.created(getUri(UUID.randomUUID())).body(new Cliente());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }
}
