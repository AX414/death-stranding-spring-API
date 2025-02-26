package br.com.death.strandingAPI.dtos;

import br.com.death.strandingAPI.enums.StatusEntrega;

import java.time.LocalDate;
import java.util.UUID;

public record EntregaDTO(
        UUID id,
        UUID entregadorId,
        UUID pessoaId,
        UUID abrigoOrigemId,
        String descricao,
        Double peso,
        StatusEntrega status,
        LocalDate dataPedido,
        LocalDate dataInicio,
        LocalDate dataConclusao,
        Integer avaliacao,
        Integer dificuldade,
        Integer experienciaEntregador,
        Integer experienciaAbrigo
) {}
