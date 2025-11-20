package br.dev.vktgabriel.rotaliteria.upx6.core.entities.user;

import br.dev.vktgabriel.rotaliteria.upx6.core.entities.Emprestimo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(nullable = false, length = 300)
    private String senha;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;

    @OneToMany(mappedBy = "usuario")
    private List<Emprestimo> emprestimos;

    @OneToMany(mappedBy = "usuario")
    private List<EnderecoUsuario> enderecoUsuarios;

    @CreatedDate
    private LocalDateTime dataCadastro;
}
