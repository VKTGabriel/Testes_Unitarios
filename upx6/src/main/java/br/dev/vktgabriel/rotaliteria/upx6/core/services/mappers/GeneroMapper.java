package br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequesstGenero;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestAutor;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseGenero;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Autor;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Genero;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface GeneroMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "livros", ignore = true)
    @Mapping(target = "isDestaque", source = "destaque")
    Genero toEntity(RequesstGenero requesstGenero);

    @Mapping(target = "destaque", source = "isDestaque")
    ResponseGenero toResponse(Genero genero);
}
