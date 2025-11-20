package br.dev.vktgabriel.pratica6.Testes.service;

import br.dev.vktgabriel.pratica6.Testes.controller.dto.RequestClienteDTO;
import br.dev.vktgabriel.pratica6.Testes.model.Cliente;
import br.dev.vktgabriel.pratica6.Testes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente salvar(RequestClienteDTO clienteDTO) {
        return new Cliente();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }
}
