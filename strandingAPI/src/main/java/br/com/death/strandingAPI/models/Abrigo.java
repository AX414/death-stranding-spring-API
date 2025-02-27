package br.com.death.strandingAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Hidden
@Entity
@Table(name="abrigo")
public class Abrigo implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public Abrigo() {
    }

    public Abrigo(UUID id, String nome, List<Afinidade> afinidades, List<Pessoa> residentes, List<Entrega> historicoEntregas) {
        this.id = id;
        this.nome = nome;
        this.afinidades = afinidades;
        this.residentes = residentes;
        this.historicoEntregas = historicoEntregas;
    }

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
