package br.com.death.strandingAPI.controllers;

import br.com.death.strandingAPI.dtos.EntregadorDTO;
import br.com.death.strandingAPI.services.EntregadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(description = "Retorna todos os entregadores cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entregadores encontrados com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhum entregador encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @GetMapping
    public List<EntregadorDTO> listarTodos() {
        return entregadorService.findAll();
    }
}
