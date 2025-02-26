package br.com.death.strandingAPI.services;

import br.com.death.strandingAPI.dtos.EntregadorDTO;
import br.com.death.strandingAPI.models.Entregador;
import br.com.death.strandingAPI.repositories.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    public List<EntregadorDTO> converterDTO(List<Entregador> lista) {
        return lista.stream().map(e -> new EntregadorDTO(
                        e.getId(),
                        e.getNome(),
                        e.getEmail(),
                        e.getSenha(),
                        e.getNivel(),
                        e.getExperiencia(),
                        e.getPesoAtual(),
                        e.getFotoUrl(),
                        e.getEmpresa()
                ))
                .collect(Collectors.toList());
    }

    public List<EntregadorDTO> findAll() {
        return converterDTO(entregadorRepository.findAll());
    }
}