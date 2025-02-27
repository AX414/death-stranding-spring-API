package br.com.death.strandingAPI.services;

import br.com.death.strandingAPI.dtos.AfinidadeDTO;
import br.com.death.strandingAPI.models.Afinidade;
import br.com.death.strandingAPI.repositories.AfinidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AfinidadeService {

    @Autowired
    private AfinidadeRepository afinidadeRepository;

    public List<AfinidadeDTO> converterDTO(List<Afinidade> lista) {
        return lista.stream().map(a -> new AfinidadeDTO(
                        a.getId(),
                        a.getEntregador().getNome(),
                        a.getAbrigo().getNome(),
                        a.getNivel(),
                        a.getExperiencia()
                ))
                .collect(Collectors.toList());
    }

    public List<AfinidadeDTO> findAll() {
        return converterDTO(afinidadeRepository.findAll());
    }

    public List<AfinidadeDTO> findByEntregadorNome(String nome) {
        return converterDTO(afinidadeRepository.findByEntregador_Nome(nome));
    }
}
