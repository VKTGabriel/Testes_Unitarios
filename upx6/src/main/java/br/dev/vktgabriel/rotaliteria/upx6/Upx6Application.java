package br.dev.vktgabriel.rotaliteria.upx6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
public class Upx6Application {

	public static void main(String[] args) {
		SpringApplication.run(Upx6Application.class, args);
	}

}
