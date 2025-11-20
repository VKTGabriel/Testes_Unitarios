package br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.request.RequestUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseDetailedUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {
            GrupoMapper.class, EnderecoUsuarioMapper.class
        })
public abstract class UsuarioMapper {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "grupo", ignore = true)
    @Mapping(target = "emprestimos", ignore = true)
    @Mapping(target = "enderecoUsuarios", ignore = true)
    @Mapping(target = "dataCadastro", ignore = true)
    @Mapping(target = "senha", expression = "java( passwordEncoder.encode(usuarioDTO.senha()) )")
    @Mapping(target = "cpf", expression = "java( usuarioDTO.cpf().replaceAll(\"[^0-9]\", \"\").trim() )")
    public abstract Usuario toEntity(RequestUsuario usuarioDTO);

    public abstract ResponseUsuario toResponse(Usuario usuario);

    @Mapping(target = "enderecos", source = "enderecoUsuarios")
    public abstract ResponseDetailedUsuario toDetailedResponse(Usuario usuario);
}