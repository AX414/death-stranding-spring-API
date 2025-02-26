package br.com.death.strandingAPI.controllers;

import br.com.death.strandingAPI.dtos.PessoaDTO;
import br.com.death.strandingAPI.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaDTO> listarTodas() {
        return pessoaService.findAll();
    }
}
