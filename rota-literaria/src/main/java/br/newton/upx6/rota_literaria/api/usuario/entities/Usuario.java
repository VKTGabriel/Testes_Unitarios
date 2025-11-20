package br.newton.upx6.rota_literaria.api.usuario.entities;

import br.newton.upx6.rota_literaria.api.security.entities.Grupo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
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

    @Column(nullable = false, length = 300)
    private String senha;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "id_telefone", unique = true, referencedColumnName = "id")
    private Telefone telefone;

    @ManyToOne
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;

    @OneToMany(mappedBy = "usuario")
    private List<Endereco> enderecos;

    @CreatedDate
    private LocalDateTime dataCadastro;
}