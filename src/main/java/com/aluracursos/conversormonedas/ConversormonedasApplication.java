package com.aluracursos.conversormonedas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversormonedasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConversormonedasApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Principal menu = new Principal();
        menu.mostrarMenu();
    }
}
