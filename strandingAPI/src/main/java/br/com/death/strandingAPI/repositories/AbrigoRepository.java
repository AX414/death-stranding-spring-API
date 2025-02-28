package br.com.death.strandingAPI.repositories;

import br.com.death.strandingAPI.models.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AbrigoRepository extends JpaRepository<Abrigo, UUID> {

    @Query("SELECT a FROM Abrigo a JOIN FETCH a.historicoEntregas WHERE a.id = :id")
    Optional<Abrigo> findByIdWithHistorico(@Param("id") UUID id);
    Optional<Abrigo> findByNome(String nomeAbrigo);

}
