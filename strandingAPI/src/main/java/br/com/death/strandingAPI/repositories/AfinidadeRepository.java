package br.com.death.strandingAPI.repositories;

import br.com.death.strandingAPI.models.Afinidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;

@Repository
public interface AfinidadeRepository extends JpaRepository<Afinidade, UUID> {

    List<Afinidade> findByEntregador_Nome(String nome);

    void deleteByEntregadorId(UUID id);
}
