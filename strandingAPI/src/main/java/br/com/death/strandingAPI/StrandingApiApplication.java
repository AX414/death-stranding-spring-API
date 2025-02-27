package br.com.death.strandingAPI;

import br.com.death.strandingAPI.main.Main;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StrandingApiApplication {

    public static void main(String[] args) {
        // Carregar as variáveis no sistema
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(StrandingApiApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ApplicationContext context) {
        return args -> {
            Main main = context.getBean(Main.class);
            main.consultarAPI();
        };
    }
}