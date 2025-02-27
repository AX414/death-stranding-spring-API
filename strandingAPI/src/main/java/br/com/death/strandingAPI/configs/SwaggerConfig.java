package br.com.death.strandingAPI.configs;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Hidden
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Death Stranding API")
                        .version("1.0")
                        .description("API para gerenciar entregas inspirada no universo de Death Stranding"));
    }
}
