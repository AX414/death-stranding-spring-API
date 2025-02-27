package br.com.death.strandingAPI.dtos;

import br.com.death.strandingAPI.enums.Empresa;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "DTO de Entregador")
public record EntregadorDTO(
        @Schema(description = "Identificador do entregador")
        UUID id,
        @Schema(description = "Nome do entregador")
        String nome,
        @Schema(description = "Email do entregador")
        String email,
        @Schema(description = "Senha do entregador")
        String senha,
        @Schema(description = "Nível do entregador")
        Integer nivel,
        @Schema(description = "Experiência do entregador, onde a cada 1000, sobe um nível")
        Integer experiencia,
        @Schema(description = "Peso atual, onde o peso máximo do entregador deve ser até 240kg")
        Double pesoAtual,
        @Schema(description = "URL da foto do entregador")
        String fotoUrl,
        @Schema(description = "Empresa que o entregador é vinculado", examples = {"BRIDGES", "FRAGILE_EXPRESS", "AUTONOMO"})
        Empresa empresa
) {
}