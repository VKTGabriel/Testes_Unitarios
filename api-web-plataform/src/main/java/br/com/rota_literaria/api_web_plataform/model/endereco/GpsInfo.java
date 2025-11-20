package br.com.rota_literaria.api_web_plataform.model.endereco;

import br.com.rota_literaria.api_web_plataform.model.rota.Rota;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class GpsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "latitude", length = 20, nullable = false)
    private String latitude;

    @Column(name = "longitude", length = 20, nullable = false)
    private String longitude;

    @OneToOne(mappedBy = "gpsInfo")
    private Endereco endereco;

    @ManyToMany(mappedBy = "paradas")
    private List<Rota> rotas;
}
