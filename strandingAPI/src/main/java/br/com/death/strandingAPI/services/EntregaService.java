package br.com.death.strandingAPI.services;

import br.com.death.strandingAPI.dtos.EntregaDTO;
import br.com.death.strandingAPI.models.Entrega;
import br.com.death.strandingAPI.repositories.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    public List<EntregaDTO> converterDTO(List<Entrega> lista) {
        return lista.stream().map(e -> new EntregaDTO(
                        e.getId(),
                        e.getEntregador().getId(),
                        e.getPessoa().getId(),
                        e.getAbrigoOrigem().getId(),
                        e.getDescricao(),
                        e.getPeso(),
                        e.getStatus(),
                        e.getDataPedido(),
                        e.getDataInicio(),
                        e.getDataConclusao(),
                        e.getAvaliacao(),
                        e.getDificuldade(),
                        e.getExperienciaEntregador(),
                        e.getExperienciaAbrigo()
                ))
                .collect(Collectors.toList());
    }

    public List<EntregaDTO> findAll() {
        return converterDTO(entregaRepository.findAll());
    }
}


