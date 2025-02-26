package br.com.death.strandingAPI.controllers;

import br.com.death.strandingAPI.dtos.EntregaDTO;
import br.com.death.strandingAPI.services.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @GetMapping
    public List<EntregaDTO> listarTodas() {
        return entregaService.findAll();
    }
}


