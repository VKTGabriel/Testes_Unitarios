package br.dev.vktgabriel.rotaliteria.upx6.core.repositories;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.endereco.CepInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CepRepository extends JpaRepository<CepInfo, UUID> {
    Optional<CepInfo> findByCep(String cep);
}
