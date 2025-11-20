package br.com.rota_literaria.api_web_plataform.repository.endereco;

import br.com.rota_literaria.api_web_plataform.model.endereco.CepInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface CepInfoRepository extends CrudRepository<CepInfo, UUID> {
    Optional<CepInfo> findByCep(String cep);
}
