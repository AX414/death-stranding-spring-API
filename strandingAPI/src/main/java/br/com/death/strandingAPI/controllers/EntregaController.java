package br.com.death.strandingAPI.controllers;

import br.com.death.strandingAPI.dtos.EntregaDTO;
import br.com.death.strandingAPI.dtos.EntregadorDTO;
import br.com.death.strandingAPI.models.Abrigo;
import br.com.death.strandingAPI.models.Entrega;
import br.com.death.strandingAPI.repositories.AbrigoRepository;
import br.com.death.strandingAPI.services.AbrigoService;
import br.com.death.strandingAPI.services.EntregaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @Autowired
    private AbrigoService abrigoService;

    private AbrigoRepository abrigoRepository;

    @Operation(description = "Retorna todas as entregas cadastradas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entregas encontradas com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhuma entrega encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @GetMapping
    public List<EntregaDTO> listarTodas() {
        return entregaService.findAll();
    }

    @Operation(description = "Retorna todas as entregas cadastradas de um abrigo pelo nome.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entregas encontradas com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhuma entrega encontrada."),
            @ApiResponse(responseCode = "404", description = "Abrigo não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @GetMapping("/{nomeAbrigo}")
    public ResponseEntity<List<EntregaDTO>> listarTodasEntregasPorAbrigo(@PathVariable String nomeAbrigo) {
        return entregaService.listarTodasEntregasPorAbrigo(nomeAbrigo);
    }

    @Operation(description = "Cria uma nova entrega aleatória.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Entrega criada com sucesso."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @PostMapping
    public ResponseEntity<EntregaDTO> criarEntregaAleatoria() {
        return entregaService.criarEntregaAleatoria();
    }

    @Operation(description = "Deleta uma entrega pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Entrega deletada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Não é possível excluir uma entrega."),
            @ApiResponse(responseCode = "404", description = "Entrega não encontrada."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable UUID id) {
        return entregaService.deletar(id);
    }
}


