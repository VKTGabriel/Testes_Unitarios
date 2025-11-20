package br.newton.upx6.rota_literaria.api.usuario.controllers;

import br.newton.upx6.rota_literaria.api.usuario.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;


}
