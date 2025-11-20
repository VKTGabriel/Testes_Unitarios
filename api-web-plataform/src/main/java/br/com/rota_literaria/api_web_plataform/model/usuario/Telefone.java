package br.com.rota_literaria.api_web_plataform.model.usuario;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 3)
    private String ddi;

    @Column(nullable = false, length = 2)
    private String ddd;

    @Column(nullable = false, length = 9)
    private String numero;

    @Column(name = "valido", nullable = false)
    private Boolean isValido;

    @OneToOne(mappedBy = "telefone")
    private Usuario usuario;

    public String getTelefoneForamatado() {
        return String.format("%s%s%s",
                this.ddi,
                this.ddd,
                this.numero);
    }

    public String getTelefoneDisplay() {
        return String.format("+%s (%s) %s",
                this.ddi,
                this.ddd,
                this.numero);
    }
}
