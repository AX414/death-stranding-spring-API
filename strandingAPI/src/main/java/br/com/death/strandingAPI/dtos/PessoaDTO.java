package br.com.death.strandingAPI.dtos;

import java.util.UUID;

public record PessoaDTO(
        UUID id,
        String nome,
        UUID abrigoId
) {}