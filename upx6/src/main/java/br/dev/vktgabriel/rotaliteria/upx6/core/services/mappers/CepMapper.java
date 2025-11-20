package br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseCep;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.endereco.CepInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CepMapper {

    @Mapping(target = "localidade", source = "cidade")
    ResponseCep toResponse(CepInfo cepInfo);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enderecoUsuarios", ignore = true)
    @Mapping(target = "cidade", source = "localidade")
    @Mapping(target = "cep", expression = "java( responseCep.cep().replaceAll(\"[^0-9]\", \"\") )")
    CepInfo toEntity(ResponseCep responseCep);
}
