package br.com.death.strandingAPI.services;

import br.com.death.strandingAPI.dtos.EntregadorDTO;
import br.com.death.strandingAPI.models.Entregador;
import br.com.death.strandingAPI.repositories.AfinidadeRepository;
import br.com.death.strandingAPI.repositories.EntregaRepository;
import br.com.death.strandingAPI.repositories.EntregadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private AfinidadeRepository afinidadeRepository;

    // Conversor de Entregador -> EntregadorDTO
    private EntregadorDTO converterDTO(Entregador e) {
        return new EntregadorDTO(
                e.getId(),
                e.getNome(),
                e.getEmail(),
                e.getSenha(),
                e.getNivel(),
                e.getExperiencia(),
                e.getPesoAtual(),
                e.getFotoUrl(),
                e.getAtivo(),
                e.getEmpresa()
        );
    }

    // Busca todos os entregadores
    public List<EntregadorDTO> findAll() {
        return entregadorRepository.findAll().stream()
                .map(this::converterDTO)
                .collect(Collectors.toList());
    }

    // Cadastro de um novo entregador
    public ResponseEntity<String> cadastrar(EntregadorDTO dto) {
        if (dto.nome() == null || dto.email() == null || dto.senha() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome, email e senha são obrigatórios.");
        }

        if (entregadorRepository.existsByEmail(dto.email())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um entregador com esse email.");
        }

        Entregador novoEntregador = new Entregador();
        novoEntregador.setNome(dto.nome());
        novoEntregador.setEmail(dto.email());
        novoEntregador.setSenha(dto.senha());
        novoEntregador.setNivel(dto.nivel() != null ? dto.nivel() : 0);
        novoEntregador.setExperiencia(dto.experiencia() != null ? dto.experiencia() : 0);
        novoEntregador.setPesoAtual(dto.pesoAtual() != null ? dto.pesoAtual() : 0.0);
        novoEntregador.setFotoUrl(dto.fotoUrl());
        novoEntregador.setEmpresa(dto.empresa());
        novoEntregador.setAtivo(1);

        entregadorRepository.save(novoEntregador);

        return ResponseEntity.status(HttpStatus.CREATED).body("Entregador cadastrado com sucesso.");
    }

    // Desativa um entregador
    public ResponseEntity<String> desativarEntregador(UUID id) {
        Optional<Entregador> entregadorOptional = entregadorRepository.findById(id);

        if (entregadorOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado.");
        }

        Entregador entregador = entregadorOptional.get();

        if (entregador.getAtivo() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A conta já está desativada.");
        }

        entregador.setAtivo(0);
        entregadorRepository.save(entregador);

        return ResponseEntity.status(HttpStatus.OK).body("Conta desativada com sucesso.");
    }

    @Transactional
    public ResponseEntity<String> deletar(UUID id) {
        Optional<Entregador> entregador = entregadorRepository.findById(id);

        if (entregador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado.");
        }

        Entregador e = entregador.get();

        if (e.getAtivo() != 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não é possível excluir um entregador ativo.");
        }

        entregaRepository.deleteByEntregadorId(id);
        afinidadeRepository.deleteByEntregadorId(id);
        entregadorRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Busca entregador por ID e retorna como DTO
    public ResponseEntity<EntregadorDTO> buscarPorId(UUID id) {
        Optional<Entregador> entregador = entregadorRepository.findById(id);

        if (entregador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(converterDTO(entregador.get()));
    }
}
