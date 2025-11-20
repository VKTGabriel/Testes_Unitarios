package br.com.rota_literaria.api_web_plataform.model.security;

import br.com.rota_literaria.api_web_plataform.model.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "grupo")
    private List<Usuario> usuarios;

    @ManyToMany
    @JoinTable(
            name = "grupo_autoridade",
            joinColumns = @JoinColumn(name = "id_grupo"),
            inverseJoinColumns = @JoinColumn(name = "id_autoridade")
    )
    private List<Autoridade> autorizacoes;
}
