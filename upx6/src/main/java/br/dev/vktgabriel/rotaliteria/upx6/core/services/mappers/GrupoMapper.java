package br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestGrupo;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseGrupo;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.Grupo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface GrupoMapper {
    ResponseGrupo toResponse(Grupo grupo);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuarios", ignore = true)
    @Mapping(target = "nome", expression = "java( responseGrupo.nome().toUpperCase() )")
    Grupo toEntity(RequestGrupo responseGrupo);
}
