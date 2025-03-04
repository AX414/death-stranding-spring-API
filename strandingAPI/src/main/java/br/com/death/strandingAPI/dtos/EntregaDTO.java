package br.com.death.strandingAPI.dtos;

import br.com.death.strandingAPI.enums.StatusEntrega;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.UUID;

@Schema(description = "DTO de Abrigo")
public record EntregaDTO(
        @Schema(description = "Identificador da entrega")
        UUID id,
        @Schema(description = "Entregador responsável pela entrega")
        String entregador,
        @Schema(description = "Pessoa que pediu que a entrega fosse feita")
        String remetente,
        @Schema(description = "Pessoa a quem está endereçada a entrega")
        String destinatario,
        @Schema(description = "Descrição da entrega")
        String descricao,
        @Schema(description = "Peso da entrega")
        Double peso,
        @Schema(description = "Status da entrega", examples = {"ENTREGUE","PENDENTE","PERDIDO"})
        StatusEntrega status,
        @Schema(description = "Data de quando o pedido foi feito")
        LocalDate dataPedido,
        @Schema(description = "Data de quando o pedido foi aceito por um entregador")
        LocalDate dataInicio,
        @Schema(description = "Data de quando um pedido foi encerrado, sendo entregue ou perdido")
        LocalDate dataConclusao,
        @Schema(description = "Dificuldade da entrega, sendo de 1 até 5")
        Integer dificuldade,
        @Schema(description = "Quantia de experiência que o entregador e o abrigo irá receber")
        Integer experiencia
) {}
