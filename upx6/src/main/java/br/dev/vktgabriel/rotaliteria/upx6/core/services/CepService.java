package br.dev.vktgabriel.rotaliteria.upx6.core.services;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.endereco.CepInfo;
import br.dev.vktgabriel.rotaliteria.upx6.core.repositories.CepRepository;
import br.dev.vktgabriel.rotaliteria.upx6.core.services.mappers.CepMapper;
import br.dev.vktgabriel.rotaliteria.upx6.dependencies.CepClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CepService {
    private final CepRepository cepRepository;
    private final CepMapper cepMapper;
    private final CepClient cepClient;

    public CepInfo saveIfNotExists(String cep) {
        CepInfo cepInfo = cepRepository.findByCep(cep).orElse(null);
        if (cepInfo != null) {
            return cepInfo;
        }
        cepInfo = cepMapper.toEntity(cepClient.getCepInfo(cep));
        return cepRepository.save(cepInfo);
    }
}