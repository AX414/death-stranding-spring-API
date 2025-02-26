package br.com.death.strandingAPI.services;

import br.com.death.strandingAPI.dtos.AbrigoDTO;
import br.com.death.strandingAPI.models.Abrigo;
import br.com.death.strandingAPI.repositories.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository abrigoRepository;

    public List<AbrigoDTO> converterDTO(List<Abrigo> lista) {
        return lista.stream().map(a -> new AbrigoDTO(
                        a.getId(),
                        a.getNome()
                ))
                .collect(Collectors.toList());
    }

    public List<AbrigoDTO> findAll() {
        return converterDTO(abrigoRepository.findAll());
    }

}
