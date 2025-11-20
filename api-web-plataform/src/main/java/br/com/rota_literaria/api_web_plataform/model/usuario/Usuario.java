package br.com.rota_literaria.api_web_plataform.model.usuario;

import br.com.rota_literaria.api_web_plataform.model.biblioteca.equipe.UsuarioBiblioteca;
import br.com.rota_literaria.api_web_plataform.model.emprestimo.Emprestimo;
import br.com.rota_literaria.api_web_plataform.model.endereco.UsuarioEndereco;
import br.com.rota_literaria.api_web_plataform.model.security.Grupo;
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

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "senha",nullable = false, length = 300)
    private String senha;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    private String cpf;

    @OneToOne
    @JoinColumn(name = "id_email", nullable = false, referencedColumnName = "id")
    private Email email;

    @OneToOne
    @JoinColumn(name = "id_telefone", referencedColumnName = "id")
    private Telefone telefone;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioEndereco> usuarioEnderecos;

    @OneToMany(mappedBy = "usuario")
    private List<Emprestimo> emprestimos;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioBiblioteca> bibliotecas;

    @ManyToOne
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;

    @CreatedDate
    private LocalDateTime dataCadastro;
}