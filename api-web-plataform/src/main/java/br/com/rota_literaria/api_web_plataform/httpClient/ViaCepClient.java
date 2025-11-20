package br.com.rota_literaria.api_web_plataform.httpClient;

import br.com.rota_literaria.api_web_plataform.model.endereco.CepInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "ViaCep",
        url = "viacep.com.br/ws"
)
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    CepInfo getCep(@PathVariable("cep") String cep);
}
