package br.com.death.strandingAPI.controllers;

import br.com.death.strandingAPI.dtos.AfinidadeDTO;
import br.com.death.strandingAPI.services.AfinidadeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/afinidades")
public class AfinidadeController {

    @Autowired
    private AfinidadeService afinidadeService;

    @Operation(description = "Retorna todos os estados de afinidade entre entregadores e abrigos cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Afinidades encontradas com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhuma afinidade encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @GetMapping
    public List<AfinidadeDTO> listarTodos() {
        return afinidadeService.findAll();
    }

    @Operation(description = "Retorna todos os estados de afinidade entre um entregador e os abrigos cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Afinidades encontradas com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhuma afinidade encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @GetMapping("/{nome}")
    public ResponseEntity<List<AfinidadeDTO>> getAfinidadesPorEntregador(
            @Parameter(description = "O parâmetro utilizado é o nome do entregador escrito normalmente.")
            @PathVariable String nome) {
        List<AfinidadeDTO> afinidades = afinidadeService.findByEntregadorNome(nome);
        return ResponseEntity.ok(afinidades);
    }
}

