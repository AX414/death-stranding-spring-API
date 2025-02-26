package br.com.death.strandingAPI.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="abrigo")
public class Abrigo implements Serializable {

    private static final long serialVerionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @OneToMany(mappedBy = "abrigo")
    private List<Afinidade> afinidades;

    @OneToMany(mappedBy = "abrigo")
    private List<Pessoa> residentes;

    @OneToMany(mappedBy = "abrigoOrigem")
    private List<Entrega> historicoEntregas;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Afinidade> getAfinidades() {
        return afinidades;
    }

    public void setAfinidades(List<Afinidade> afinidades) {
        this.afinidades = afinidades;
    }

    public List<Pessoa> getResidentes() {
        return residentes;
    }

    public void setResidentes(List<Pessoa> residentes) {
        this.residentes = residentes;
    }

    public List<Entrega> getHistoricoEntregas() {
        return historicoEntregas;
    }

    public void setHistoricoEntregas(List<Entrega> historicoEntregas) {
        this.historicoEntregas = historicoEntregas;
    }

    @Override
    public String toString() {
        return "Abrigo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", afinidades=" + afinidades +
                ", residentes=" + residentes +
                ", historicoEntregas=" + historicoEntregas +
                '}';
    }
}
