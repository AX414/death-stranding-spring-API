package br.com.death.strandingAPI.dtos;

import br.com.death.strandingAPI.models.Abrigo;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "DTO de Pessoa")
public record PessoaDTO(
        @Schema(description = "Identificador da pessoa")
        UUID id,
        @Schema(description = "Nome da pessoa")
        String nome,
        @Schema(description = "Abrigo do qual ela reside")
        String abrigo
) {}