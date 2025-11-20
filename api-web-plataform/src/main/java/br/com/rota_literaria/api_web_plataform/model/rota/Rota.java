package br.com.rota_literaria.api_web_plataform.model.rota;

import br.com.rota_literaria.api_web_plataform.model.endereco.GpsInfo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_partida", nullable = false)
    private GpsInfo partida;

    @ManyToOne
    @JoinColumn(name = "id_destino", nullable = false)
    private GpsInfo destino;

    @Column(name = "limite-distancia-paradas", nullable = false)
    private Integer limiteDistanciaParadas;

    @ManyToMany
    @JoinTable(
            name = "rota_parada",
            joinColumns = @JoinColumn(name = "id_rota"),
            inverseJoinColumns = @JoinColumn(name = "id_parada")
    )
    private List<GpsInfo> paradas;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;
}
