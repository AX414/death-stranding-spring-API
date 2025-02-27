package br.com.death.strandingAPI.controllers;

import br.com.death.strandingAPI.dtos.EntregadorDTO;
import br.com.death.strandingAPI.services.EntregadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @Operation(description = "Cadastra um novo entregador.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Entregador cadastrado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida."),
            @ApiResponse(responseCode = "409", description = "Já existe um entregador com esse email."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody EntregadorDTO dto) {
        return entregadorService.cadastrar(dto);
    }

    @Operation(description = "Desativa a conta de um entregador pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Conta desativada com sucesso."),
            @ApiResponse(responseCode = "400", description = "A conta já está desativada."),
            @ApiResponse(responseCode = "404", description = "Entregador não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @PutMapping("/desativar/{id}")
    public ResponseEntity<String> desativarEntregador(@PathVariable UUID id) {
        return entregadorService.desativarEntregador(id);
    }


    @Operation(description = "Deleta um entregador pelo ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Entregador deletado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Não é possível excluir um entregador ativo."),
            @ApiResponse(responseCode = "404", description = "Entregador não encontrado."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable UUID id) {
        return entregadorService.deletar(id);
    }
}
