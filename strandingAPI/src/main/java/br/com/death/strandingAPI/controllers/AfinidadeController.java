package br.com.death.strandingAPI.controllers;

import br.com.death.strandingAPI.dtos.AfinidadeDTO;
import br.com.death.strandingAPI.services.AfinidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/afinidades")
public class AfinidadeController {

    @Autowired
    private AfinidadeService afinidadeService;

    @GetMapping
    public List<AfinidadeDTO> listarTodos() {
        return afinidadeService.findAll();
    }
}

