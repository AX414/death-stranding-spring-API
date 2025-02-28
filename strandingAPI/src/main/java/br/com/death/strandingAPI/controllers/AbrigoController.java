package br.com.death.strandingAPI.controllers;

import br.com.death.strandingAPI.dtos.AbrigoDTO;
import br.com.death.strandingAPI.services.AbrigoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/abrigos")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    @Operation(description = "Retorna todos os abrigos cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Abrigos encontrados com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhum abrigo encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @GetMapping
    public List<AbrigoDTO> listarTodos() {
        return abrigoService.findAll();
    }
}