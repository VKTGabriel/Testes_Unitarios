package br.dev.vktgabriel.rotaliteria.upx6.core.entities.endereco;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.biblioteca.Biblioteca;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_cep_info")
    private CepInfo cepInfo;

    @Column(nullable = false)
    private Integer numero;

    @Column(length = 100)
    private String complemento;

    @Column(length = 100)
    private String referencia;
}