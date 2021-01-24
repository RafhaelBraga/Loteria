package com.braga.loteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LoteriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoteriaApplication.class, args);
	}

}
