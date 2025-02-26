package br.com.death.strandingAPI.services;

import br.com.death.strandingAPI.dtos.PessoaDTO;
import br.com.death.strandingAPI.models.Pessoa;
import br.com.death.strandingAPI.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDTO> converterDTO(List<Pessoa> lista) {
        return lista.stream().map(p -> new PessoaDTO(
                        p.getId(),
                        p.getNome(),
                        p.getAbrigo().getId()
                ))
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> findAll() {
        return converterDTO(pessoaRepository.findAll());
    }
}
