package br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestAutor;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseAutor;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AutorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "livros", ignore = true)
    Autor toEntity(RequestAutor requestAutor);

    ResponseAutor toResponse(Autor autor);
}
