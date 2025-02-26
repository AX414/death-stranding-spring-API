package br.com.death.strandingAPI.repositories;

import br.com.death.strandingAPI.models.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbrigoRepository extends JpaRepository<Abrigo, UUID> {
}
