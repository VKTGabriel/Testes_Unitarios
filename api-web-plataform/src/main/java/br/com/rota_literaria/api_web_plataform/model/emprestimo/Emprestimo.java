package br.com.rota_literaria.api_web_plataform.model.emprestimo;

import br.com.rota_literaria.api_web_plataform.model.biblioteca.acervo.ItemAcervo;
import br.com.rota_literaria.api_web_plataform.model.usuario.Usuario;
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

    @CreatedDate
    @Column(name = "data_solicitacao", nullable = false, updatable = false)
    private LocalDateTime dataSolicitacao;

    @Column(name = "data_entrega", nullable = false)
    private LocalDate dataEntrega;

    @Column(name = "data_devolucao", nullable = false)
    private LocalDate dataDevolucao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusEmprestimo status;
}