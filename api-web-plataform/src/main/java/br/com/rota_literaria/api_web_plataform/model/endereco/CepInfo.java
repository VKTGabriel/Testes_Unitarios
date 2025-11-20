package br.com.rota_literaria.api_web_plataform.model.endereco;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class CepInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "cep",nullable = false, unique = true, length = 10)
    private String cep;

    @Column(name = "uf", nullable = false, length = 60)
    private String uf;

    @Column(name = "estado",nullable = false, length = 60)
    private String estado;

    @Column(name = "cidade",nullable = false, length = 100)
    private String localidade;

    @Column(name = "bairro",nullable = false, length = 60)
    private String bairro;

    @Column(name = "rua",nullable = false, length = 60)
    private String logradouro;

    @Column(name = "referencia", length = 60)
    private String complemento;

    public boolean checarElegibilidade() {
        return false;
    }
}