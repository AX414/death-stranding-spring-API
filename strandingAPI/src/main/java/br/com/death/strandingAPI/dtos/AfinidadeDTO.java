package br.com.death.strandingAPI.dtos;

import java.util.UUID;

public record AfinidadeDTO(
        UUID id,
        UUID entregadorId,
        UUID abrigoId,
        Integer nivel,
        Integer experiencia
) {}

