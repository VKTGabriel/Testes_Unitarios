package br.newton.upx6.rota_literaria.api.security.repositories;

import br.newton.upx6.rota_literaria.api.security.entities.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GrupoRepository extends JpaRepository<Grupo, UUID> {
}
