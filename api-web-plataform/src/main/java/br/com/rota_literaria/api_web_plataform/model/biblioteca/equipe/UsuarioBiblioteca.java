package br.com.rota_literaria.api_web_plataform.model.biblioteca.equipe;

import br.com.rota_literaria.api_web_plataform.model.biblioteca.Biblioteca;
import br.com.rota_literaria.api_web_plataform.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UsuarioBiblioteca {
    @EmbeddedId
    private UsuarioBibliotecaKey id;

    @ManyToOne
    @MapsId("bibliotecaID")
    @JoinColumn(name = "id_biblioteca")
    private Biblioteca biblioteca;

    @ManyToOne
    @MapsId("usuarioID")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private CargoBiblioteca cargo;
}
