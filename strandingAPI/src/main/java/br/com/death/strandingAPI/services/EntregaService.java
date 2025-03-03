package br.com.death.strandingAPI.services;

import br.com.death.strandingAPI.dtos.EntregaDTO;
import br.com.death.strandingAPI.enums.StatusEntrega;
import br.com.death.strandingAPI.models.Abrigo;
import br.com.death.strandingAPI.models.Entrega;
import br.com.death.strandingAPI.models.Pessoa;
import br.com.death.strandingAPI.repositories.AbrigoRepository;
import br.com.death.strandingAPI.repositories.EntregaRepository;
import br.com.death.strandingAPI.repositories.EntregadorRepository;
import br.com.death.strandingAPI.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private AbrigoRepository abrigoRepository;

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<EntregaDTO> converterDTO(List<Entrega> lista) {
        return lista.stream().map(e -> new EntregaDTO(
                        e.getId(),
                        e.getEntregador() != null ? e.getEntregador().getNome() : "Sem entregador",
                        e.getRemetente().getNome(),
                        e.getDestinatario().getNome(),
                        e.getDescricao(),
                        e.getPeso(),
                        e.getStatus(),
                        e.getDataPedido(),
                        e.getDataInicio(),
                        e.getDataConclusao(),
                        e.getDificuldade(),
                        e.getExperiencia()
                ))
                .collect(Collectors.toList());
    }

    public List<EntregaDTO> findAll() {
        return converterDTO(entregaRepository.findAll());
    }

    public ResponseEntity<String> deletar(UUID id) {
        var entrega = entregaRepository.findById(id);

        if (entrega.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrega não encontrada.");
        }

        try {
            var entregaExistente = entrega.get();

            // Retira a entrega da lista do entregador, se existir
            if (entregaExistente.getEntregador() != null) {
                var entregador = entregadorRepository.findById(entregaExistente.getEntregador().getId());
                if (entregador.isPresent()) {
                    entregador.get().getEntregas().remove(entregaExistente);
                    entregadorRepository.save(entregador.get());
                }
            }

            // Retira a entrega da lista de entregas enviadas do abrigo de origem
            if (entregaExistente.getRemetente().getAbrigo() != null) {
                var abrigoOrigem = abrigoRepository.findById(entregaExistente.getRemetente().getAbrigo().getId());
                if (abrigoOrigem.isPresent()) {
                    abrigoOrigem.get().getEntregasEnviadas().remove(entregaExistente);
                    abrigoRepository.save(abrigoOrigem.get());
                }
            }

            // Retira a entrega da lista de entregas recebidas do abrigo de destino
            if (entregaExistente.getDestinatario().getAbrigo() != null) {
                var abrigoDestino = abrigoRepository.findById(entregaExistente.getDestinatario().getAbrigo().getId());
                if (abrigoDestino.isPresent()) {
                    abrigoDestino.get().getEntregasRecebidas().remove(entregaExistente);
                    abrigoRepository.save(abrigoDestino.get());
                }
            }

            // Deleta a entrega
            entregaRepository.delete(entregaExistente);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 não tem corpo
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao excluir a entrega: " + e.getMessage());
        }
    }

    public ResponseEntity<EntregaDTO> criarEntregaAleatoria() {
        try {
            List<Pessoa> pessoas = pessoaRepository.findAll();

            if (pessoas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null); // Não há pessoas disponíveis
            }

            Random random = new Random();
            List<String> descricoes = List.of(
                    "Entrega urgente de suprimentos médicos",
                    "Pacote de ferramentas especializadas",
                    "Encomenda confidencial — manuseie com cuidado",
                    "Suprimento alimentar para longas viagens",
                    "Entrega de peças de reposição para veículos",
                    "Correspondência oficial da BRIDGES",
                    "Remessa de roupas térmicas",
                    "Material de construção leve",
                    "Documentos importantes",
                    "Pacote de dispositivos eletrônicos",
                    "Entrega de kits de primeiros socorros",
                    "Encomenda de medicamentos",
                    "Recursos de fabricação para abrigos",
                    "Pacote de baterias de longa duração",
                    "Caixa de materiais recicláveis"
            );

            Pessoa remetente = pessoas.get(random.nextInt(pessoas.size()));
            Pessoa destinatario = pessoas.get(random.nextInt(pessoas.size()));

            Entrega entrega = new Entrega();
            entrega.setRemetente(remetente);
            entrega.setDestinatario(destinatario);
            entrega.setDescricao(descricoes.get(random.nextInt(descricoes.size())));
            entrega.setStatus(StatusEntrega.PENDENTE);
            entrega.setDataPedido(LocalDate.now());
            entrega.setDificuldade(random.nextInt(5) + 1);
            entrega.setExperiencia(random.nextInt(350) + 1);

            double pesoAleatorio = random.nextDouble(100) + 1;
            double pesoFormatado = Math.round(pesoAleatorio * 100.0) / 100.0;
            entrega.setPeso(pesoFormatado); // Peso entre 1 e 100kg

            entregaRepository.save(entrega);

            Abrigo abrigoOrigem = remetente.getAbrigo();
            abrigoOrigem.getEntregasEnviadas().add(entrega);
            abrigoRepository.save(abrigoOrigem);

            Abrigo abrigoDestino = destinatario.getAbrigo();
            abrigoDestino.getEntregasRecebidas().add(entrega);
            abrigoRepository.save(abrigoDestino);

            EntregaDTO entregaDTO = new EntregaDTO(
                    entrega.getId(),
                    remetente.getNome(),
                    abrigoOrigem.getNome(),
                    entrega.getDescricao(),
                    entrega.getDescricao(),
                    entrega.getPeso(),
                    entrega.getStatus(),
                    entrega.getDataInicio(),
                    entrega.getDataConclusao(),
                    entrega.getDataConclusao(),
                    entrega.getDificuldade(),
                    entrega.getExperiencia());

            return ResponseEntity.status(HttpStatus.CREATED).body(entregaDTO);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Em caso de erro, retorna status 500
        }
    }


    public ResponseEntity<List<EntregaDTO>> listarTodasEntregasPorAbrigo(String nomeAbrigo) {
        try {
            Optional<Abrigo> abrigo = abrigoRepository.findByNome(nomeAbrigo);

            if (abrigo.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            // Junta as entregas enviadas e recebidas
            List<Entrega> entregas = new ArrayList<>();
            entregas.addAll(abrigo.get().getEntregasEnviadas());
            entregas.addAll(abrigo.get().getEntregasRecebidas());

            if (entregas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }

            List<EntregaDTO> entregasDTO = entregas.stream().map(entrega -> new EntregaDTO(
                    entrega.getId(),
                    entrega.getEntregador() != null ? entrega.getEntregador().getNome() : "Sem entregador",
                    entrega.getRemetente().getNome(),
                    entrega.getDestinatario().getNome(),
                    entrega.getDescricao(),
                    entrega.getPeso(),
                    entrega.getStatus(),
                    entrega.getDataPedido(),
                    entrega.getDataInicio(),
                    entrega.getDataConclusao(),
                    entrega.getDificuldade(),
                    entrega.getExperiencia()
            )).collect(Collectors.toList());

            return ResponseEntity.status(HttpStatus.OK).body(entregasDTO);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}



