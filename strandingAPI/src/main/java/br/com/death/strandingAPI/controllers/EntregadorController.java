package br.com.death.strandingAPI.controllers;

import br.com.death.strandingAPI.dtos.EntregadorDTO;
import br.com.death.strandingAPI.services.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    @GetMapping
    public List<EntregadorDTO> listarTodos() {
        return entregadorService.findAll();
    }
}
