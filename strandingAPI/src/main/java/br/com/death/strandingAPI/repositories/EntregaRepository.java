package br.com.death.strandingAPI.repositories;

import br.com.death.strandingAPI.models.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, UUID> {
}
