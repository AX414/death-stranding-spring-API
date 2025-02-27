package br.com.death.strandingAPI.models;

import br.com.death.strandingAPI.enums.Empresa;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Hidden
@Entity
@Table(name = "entregador")
public class Entregador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;
    private String email;
    private String senha;
    private Integer nivel;
    private Integer experiencia;
    private Double pesoAtual;

    //A foto é irrelevante, mais para ficar bonitinho
    @Column(nullable = true)
    private String fotoUrl;

    //Fragile Express, Briges ou autônomo
    @Enumerated(EnumType.STRING)
    private Empresa empresa;

    @Column(nullable = false)
    private Integer ativo;

    //Lista que servirá de histórico de entrega
    @OneToMany(mappedBy = "entregador")
    private List<Entrega> entregas;

    public Entregador() {
    }

    public Entregador(UUID id, String nome, String email, String senha, Integer nivel, Integer experiencia, Double pesoAtual, String fotoUrl, Empresa empresa, Integer ativo, List<Entrega> entregas) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.pesoAtual = pesoAtual;
        this.fotoUrl = fotoUrl;
        this.empresa = empresa;
        this.ativo = ativo;
        this.entregas = entregas;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public Double getPesoAtual() {
        return pesoAtual;
    }

    public void setPesoAtual(Double pesoAtual) {
        this.pesoAtual = pesoAtual;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<Entrega> entregas) {
        this.entregas = entregas;
    }

    @Override
    public String toString() {
        return "Entregador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nivel=" + nivel +
                ", experiencia=" + experiencia +
                ", pesoAtual=" + pesoAtual +
                ", fotoUrl='" + fotoUrl + '\'' +
                ", empresa=" + empresa +
                ", ativo=" + ativo +
                ", entregas=" + entregas +
                '}';
    }
}
