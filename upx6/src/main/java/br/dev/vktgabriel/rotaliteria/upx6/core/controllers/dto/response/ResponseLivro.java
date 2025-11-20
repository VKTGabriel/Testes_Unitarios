package br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response;

import java.util.List;
import java.util.UUID;

public record ResponseLivro(
        UUID id,
        String isbn,
        String titulo,
        String sinopse,
        String urlCapa,
        Integer edicao,
        Integer numeroPaginas,
        ResponseAutor autor,
        ResponseEditora editora,
        List<ResponseGenero> generos
) {
}