package br.dev.vktgabriel.pratica6.Testes.repository;

import br.dev.vktgabriel.pratica6.Testes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}
