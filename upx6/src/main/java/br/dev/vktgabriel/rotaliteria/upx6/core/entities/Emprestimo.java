package br.dev.vktgabriel.rotaliteria.upx6.core.entities;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.biblioteca.ItemAcervo;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.EnderecoUsuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.entities.user.Usuario;
import br.dev.vktgabriel.rotaliteria.upx6.core.enums.EstadoEmprestimoEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_item_acervo")
    private ItemAcervo itemAcervo;

    @ManyToOne
    @JoinColumn(name = "id_endereco_entrega")
    private EnderecoUsuario enderecoEntrega;

    @Enumerated(EnumType.STRING)
    private EstadoEmprestimoEnum estado;

    @Column(name = "data_entrega")
    private LocalDate dataEntrega;

    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;

    @Column(name = "data_solicitacao")
    @CreatedDate
    private LocalDateTime dataSolicitacao;
}