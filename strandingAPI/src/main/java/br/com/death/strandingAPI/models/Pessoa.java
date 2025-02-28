package br.com.death.strandingAPI.models;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Hidden
@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "abrigo_id")
    private Abrigo abrigo;

    @OneToMany(mappedBy = "pessoa")
    private List<Entrega> entregasRecebidas;

    public Pessoa() {
    }

    public Pessoa(UUID id, String nome, Abrigo abrigo, List<Entrega> entregasRecebidas) {
        this.id = id;
        this.nome = nome;
        this.abrigo = abrigo;
        this.entregasRecebidas = entregasRecebidas;
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

    public Abrigo getAbrigo() {
        return abrigo;
    }

    public void setAbrigo(Abrigo abrigo) {
        this.abrigo = abrigo;
    }

    public List<Entrega> getEntregasRecebidas() {
        return entregasRecebidas;
    }

    public void setEntregasRecebidas(List<Entrega> entregasRecebidas) {
        this.entregasRecebidas = entregasRecebidas;
    }

    @Override
    public String toString() {
        return "PESSOA -> | UUID: "+id+
                " | Nome: "+nome+
                " | Abrigo: "+abrigo.getNome();
    }
}
