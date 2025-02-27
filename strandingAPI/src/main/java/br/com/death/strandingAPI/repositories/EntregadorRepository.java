package br.com.death.strandingAPI.repositories;

import br.com.death.strandingAPI.models.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, UUID> {

    Optional<Entregador> findById(UUID id);
    Optional<Entregador> findByNome(String nome);
    Optional<Entregador> findByEmail(String email);
    Optional<Entregador> findByEmailAndSenha(String email, String senha);
    boolean existsByEmail(String email);
}
