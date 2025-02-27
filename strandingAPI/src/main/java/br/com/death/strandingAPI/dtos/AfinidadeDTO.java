package br.com.death.strandingAPI.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "DTO de Afinidade")
public record AfinidadeDTO(
        @Schema(description = "Identificador de afinidade")
        UUID id,
        @Schema(description = "Nome do entregador")
        String entregador,
        @Schema(description = "Nome do Abrigo")
        String abrigoId,
        @Schema(description = "Nível de afinidade entre entregador e abrigo, indo de 1 até 5")
        Integer nivel,
        @Schema(description = "Quantidade de experiência acumulada, a cada 1000xp, sobe um nível de afinidade até alcançar o nível máximo")
        Integer experiencia
) {}

