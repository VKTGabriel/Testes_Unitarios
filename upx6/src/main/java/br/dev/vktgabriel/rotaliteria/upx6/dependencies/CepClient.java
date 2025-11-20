package br.dev.vktgabriel.rotaliteria.upx6.dependencies;

import br.dev.vktgabriel.rotaliteria.upx6.core.controllers.dto.response.ResponseCep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "vaicep")
public interface CepClient {

    @GetMapping("{cep}/json/")
    ResponseCep getCepInfo(@PathVariable String cep);
}
