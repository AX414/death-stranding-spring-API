package br.com.death.strandingAPI.controllers;

import br.com.death.strandingAPI.dtos.EntregaDTO;
import br.com.death.strandingAPI.dtos.PessoaDTO;
import br.com.death.strandingAPI.services.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Operation(description = "Retorna todas as pessoas cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoas encontradas com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhuma pessoa encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @GetMapping
    public List<PessoaDTO> listarTodas() {
        return pessoaService.findAll();
    }
}
