package br.com.death.strandingAPI;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StrandingApiApplication {
    //implements CommandLineRunner
    public static void main(String[] args) {
        // Carregar as variáveis no sistema
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(StrandingApiApplication.class, args);
    }

	/*
	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
	}*/
}
