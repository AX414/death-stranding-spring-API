package br.com.death.strandingAPI.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "DTO de Abrigo")
public record AbrigoDTO(
        @Schema(description = "Identificador do abrigo")
        UUID id,
        @Schema(description = "Nome do Abrigo")
        String nome
) {}