package br.com.death.strandingAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;
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
    private List<Pessoa> moradores;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "remetente_id")
    private List<Entrega> entregasEnviadas;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "destinatario_id")
    private List<Entrega> entregasRecebidas;

    public Abrigo() {
    }

    public Abrigo(UUID id, String nome, List<Afinidade> afinidades, List<Pessoa> moradores, List<Entrega> entregasEnviadas, List<Entrega> entregasRecebidas) {
        this.id = id;
        this.nome = nome;
        this.afinidades = afinidades;
        this.moradores = moradores;
        this.entregasEnviadas = entregasEnviadas;
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

    public List<Afinidade> getAfinidades() {
        return afinidades;
    }

    public void setAfinidades(List<Afinidade> afinidades) {
        this.afinidades = afinidades;
    }

    public List<Pessoa> getMoradores() {
        return moradores;
    }

    public void setMoradores(List<Pessoa> moradores) {
        this.moradores = moradores;
    }

    public List<Entrega> getEntregasEnviadas() {
        return entregasEnviadas;
    }

    public void setEntregasEnviadas(List<Entrega> entregasEnviadas) {
        this.entregasEnviadas = entregasEnviadas;
    }

    public List<Entrega> getEntregasRecebidas() {
        return entregasRecebidas;
    }

    public void setEntregasRecebidas(List<Entrega> entregasRecebidas) {
        this.entregasRecebidas = entregasRecebidas;
    }

    @Override
    public String toString() {
        return "ABRIGO -> |UUID: "+id+" | Nome: "+nome;
    }
}