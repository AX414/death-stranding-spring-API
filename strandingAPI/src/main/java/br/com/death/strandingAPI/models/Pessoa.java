package br.com.death.strandingAPI.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable {

    private static final long serialVerionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "abrigo_id")
    private Abrigo abrigo;

    @OneToMany(mappedBy = "pessoa")
    private List<Entrega> entregasRecebidas;

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
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", abrigo=" + abrigo +
                ", entregasRecebidas=" + entregasRecebidas +
                '}';
    }
}
