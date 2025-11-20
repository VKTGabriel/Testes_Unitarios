package br.com.rota_literaria.api_web_plataform.service.endereco;

import br.com.rota_literaria.api_web_plataform.httpClient.ViaCepClient;
import br.com.rota_literaria.api_web_plataform.controller.dto.endereco.CepDTO;
import br.com.rota_literaria.api_web_plataform.model.endereco.CepInfo;
import br.com.rota_literaria.api_web_plataform.repository.endereco.CepInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CepService {

    private final CepInfoRepository cepInfoRepository;
    private final ViaCepClient viaCepClient;

    public CepInfo findCepInfo(CepDTO cepDTO) {
        String cepFormatado = cepDTO.obterCepFormatado();
        Optional<CepInfo> cepInfo = cepInfoRepository.findByCep(cepFormatado);

        if (cepInfo.isPresent()) {
            return cepInfo.get();
        }

        CepInfo novoCep = viaCepClient.getCep(cepFormatado);
        novoCep.setCep(cepFormatado);

        return cepInfoRepository.save(novoCep);
    }
}
