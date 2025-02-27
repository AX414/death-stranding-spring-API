package br.com.death.strandingAPI.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
public class SwaggerController {
    @GetMapping("/")
    public String home(){
        return "redirect:/swagger-ui.html";
    }
}
