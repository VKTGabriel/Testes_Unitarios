package br.dev.vktgabriel.rotaliteria.upx6.core.entities.biblioteca;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.endereco.Endereco;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @OneToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "biblioteca")
    private List<ItemAcervo> itemAcervos;
}
