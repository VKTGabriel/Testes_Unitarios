package br.dev.vktgabriel.rotaliteria.upx6.core.entities.rota;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.endereco.Endereco;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.UUID;

public class Destino {
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @OneToOne
    @JoinColumn(name = "id_Endereco", nullable = false)
    private Endereco endereco;
}