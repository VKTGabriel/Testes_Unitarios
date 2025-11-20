package br.com.rota_literaria.api_web_plataform.repository.endereco;

import br.com.rota_literaria.api_web_plataform.model.endereco.Endereco;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EnderecoRepository extends CrudRepository<Endereco, UUID> {
}
