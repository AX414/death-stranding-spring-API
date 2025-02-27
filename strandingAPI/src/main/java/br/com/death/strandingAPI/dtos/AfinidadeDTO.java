package br.com.death.strandingAPI.dtos;

import java.util.UUID;

public record AfinidadeDTO(
        UUID id,
        String entregador,
        String abrigoId,
        Integer nivel,
        Integer experiencia
) {}

