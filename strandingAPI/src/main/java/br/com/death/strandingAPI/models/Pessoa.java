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

    public Pessoa() {
    }

    public Pessoa(UUID id, String nome, Abrigo abrigo) {
        this.id = id;
        this.nome = nome;
        this.abrigo = abrigo;
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

    @Override
    public String toString() {
        return "PESSOA -> | UUID: "+id+
                " | Nome: "+nome+
                " | Abrigo: "+abrigo.getNome();
    }
}
