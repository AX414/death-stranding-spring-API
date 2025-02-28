package br.com.death.strandingAPI.models;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Hidden
@Entity
@Table(name="afinidade")
public class Afinidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "entregador_id")
    private Entregador entregador;

    @ManyToOne
    @JoinColumn(name = "abrigo_id")
    private Abrigo abrigo;

    private Integer nivel;
    private Integer experiencia;

    public Afinidade() {
    }

    public Afinidade(UUID id, Entregador entregador, Abrigo abrigo, Integer nivel, Integer experiencia) {
        this.id = id;
        this.entregador = entregador;
        this.abrigo = abrigo;
        this.nivel = nivel;
        this.experiencia = experiencia;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public Abrigo getAbrigo() {
        return abrigo;
    }

    public void setAbrigo(Abrigo abrigo) {
        this.abrigo = abrigo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "AFINIDADE -> |UUID: "+id+"| Entregador: "+entregador.getNome()+
                " | Abrigo: "+abrigo.getNome()+" | Nível: "+nivel+" | Experiência: "+experiencia;
    }
}
