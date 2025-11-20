package br.dev.vktgabriel.rotaliteria.upx6.config;

import com.google.maps.GeoApiContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleAPIConfig {

    @Value("${google.apiKey}")
    private String apikey;

    @Bean
    public GeoApiContext geoApiContext() {
        return new GeoApiContext.Builder().apiKey(apikey).build();
    }
}
