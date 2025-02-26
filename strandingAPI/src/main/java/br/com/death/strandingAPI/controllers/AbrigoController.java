package br.com.death.strandingAPI.controllers;

import br.com.death.strandingAPI.dtos.AbrigoDTO;
import br.com.death.strandingAPI.services.AbrigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    @GetMapping
    public List<AbrigoDTO> listarTodos() {
        return abrigoService.findAll();
    }
}