package br.com.rota_literaria.api_web_plataform.controller;

import br.com.rota_literaria.api_web_plataform.service.endereco.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;
}