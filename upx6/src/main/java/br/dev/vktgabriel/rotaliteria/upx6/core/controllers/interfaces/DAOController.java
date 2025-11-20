package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.interfaces;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

public interface DAOController {

    default URI getLocation(UUID uuid) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{uuid}")
                .buildAndExpand(uuid)
                .toUri();
    }
}
