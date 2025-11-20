package br.newton.upx6.rota_literaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
public class RotaLiterariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RotaLiterariaApplication.class, args);
	}

}
