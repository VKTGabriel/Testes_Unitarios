package br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestLivro;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseLivro;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Livro;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.AutorService;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.EditoraService;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.GeneroService;
import br.dev.vktgabriel.rotaliteria.upx6.dependencies.implementation.S3Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {AutorMapper.class,
                EditoraMapper.class,
                GeneroMapper.class
        })
public abstract class LivroMapper {

    @Autowired
    AutorService autorService;
    @Autowired
    EditoraService editoraService;
    @Autowired
    GeneroService generoService;
    @Autowired
    S3Service s3Service;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "itemAcervos", ignore = true)
    @Mapping(target = "autor", expression = "java( autorService.getById(requestLivro.autor()) )")
    @Mapping(target = "editora", expression = "java( editoraService.getById(requestLivro.editora()) )")
    @Mapping(target = "generos", expression = "java( generoService.getListById(requestLivro.generos()) )")
    @Mapping(target = "urlCapa", ignore = true)
    public abstract Livro toEntity(RequestLivro requestLivro);

    public abstract ResponseLivro ToResponse(Livro livro);
}
