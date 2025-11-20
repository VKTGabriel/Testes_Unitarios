package br.dev.vktgabriel.rotaliteria.upx6.core.entities.biblioteca;

import br.dev.vktgabriel.rotaliteria.upx6.core.enums.EstadoConservacaoEnum;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.livro.Livro;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class ItemAcervo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_biblioteca")
    private Biblioteca biblioteca;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    @Enumerated(EnumType.STRING)
    private EstadoConservacaoEnum estado;
}
