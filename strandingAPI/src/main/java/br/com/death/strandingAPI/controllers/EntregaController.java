package br.com.death.strandingAPI.controllers;

import br.com.death.strandingAPI.dtos.EntregaDTO;
import br.com.death.strandingAPI.services.EntregaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @Operation(description = "Retorna todas as entregas cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Abrigos encontrados com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhum abrigo encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @GetMapping
    public List<EntregaDTO> listarTodas() {
        return entregaService.findAll();
    }
}


