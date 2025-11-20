package br.com.rota_literaria.api_web_plataform.model.endereco;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "cep_id", nullable = false)
    private CepInfo cepInfo;

    @Column(nullable = false, unique = true)
    private Integer numero;

    @OneToOne
    @JoinColumn(name = "id_gps_info", referencedColumnName = "id")
    private GpsInfo gpsInfo;

    @OneToMany(mappedBy = "endereco")
    private List<UsuarioEndereco> usuariosEndereco;

    public String obterEnderecoFormatado() {
        return String.format("%s, N%d - %s. CEP: %s. %s/%s",
                this.cepInfo.getLogradouro(),
                this.numero,
                this.cepInfo.getBairro(),
                this.cepInfo.getCep(),
                this.cepInfo.getLocalidade(),
                this.cepInfo.getEstado());
    }
}