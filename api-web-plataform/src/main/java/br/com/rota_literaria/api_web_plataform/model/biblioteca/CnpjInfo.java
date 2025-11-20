package br.com.rota_literaria.api_web_plataform.model.biblioteca;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class CnpjInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(mappedBy = "cnpjInfo")
    private Biblioteca biblioteca;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "alias", nullable = false)
    private String alias;
}
