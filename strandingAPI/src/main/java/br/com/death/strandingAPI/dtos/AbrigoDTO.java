package br.com.death.strandingAPI.dtos;

import java.util.UUID;

public record AbrigoDTO(
        UUID id,
        String nome
) {}