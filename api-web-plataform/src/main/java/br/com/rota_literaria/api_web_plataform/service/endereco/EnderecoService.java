package br.com.rota_literaria.api_web_plataform.service.endereco;

import br.com.rota_literaria.api_web_plataform.controller.dto.endereco.CepDTO;
import br.com.rota_literaria.api_web_plataform.controller.dto.endereco.EnderecoDTO;
import br.com.rota_literaria.api_web_plataform.model.endereco.CepInfo;
import br.com.rota_literaria.api_web_plataform.model.endereco.Endereco;
import br.com.rota_literaria.api_web_plataform.repository.endereco.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final CepService cepService;
    private final EnderecoRepository enderecoRepository;

    public Endereco salvar(CepDTO cepDTO, EnderecoDTO enderecoDTO) {
        CepInfo cep = cepService.findCepInfo(cepDTO);
        Endereco entidadeEndereco = enderecoDTO.toEndereco();
        entidadeEndereco.setCepInfo(cep);

        return enderecoRepository.save(entidadeEndereco);
    }
}
