package br.com.death.strandingAPI.models;

import br.com.death.strandingAPI.enums.StatusEntrega;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Hidden
@Entity
@Table(name="entrega")
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Version
    @Column(nullable = false)
    private Long version = 0L;

    @ManyToOne
    @JoinColumn(name = "entregador_id", nullable = true)
    private Entregador entregador;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "abrigo_origem_id")
    private Abrigo abrigoOrigem;

    private String descricao;
    private Double peso;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    private LocalDate dataPedido;
    @Column(nullable = true)
    private LocalDate dataInicio;
    @Column(nullable = true)
    private LocalDate dataConclusao;
    private Integer dificuldade;
    private Integer experienciaEntregador;
    private Integer experienciaAbrigo;

    public Entrega() {
    }

    public Entrega(UUID id, Long version, Entregador entregador, Pessoa pessoa, Abrigo abrigoOrigem, String descricao, Double peso, StatusEntrega status, LocalDate dataPedido, LocalDate dataInicio, LocalDate dataConclusao, Integer dificuldade, Integer experienciaEntregador, Integer experienciaAbrigo) {
        this.id = id;
        this.version = version;
        this.entregador = entregador;
        this.pessoa = pessoa;
        this.abrigoOrigem = abrigoOrigem;
        this.descricao = descricao;
        this.peso = peso;
        this.status = status;
        this.dataPedido = dataPedido;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.dificuldade = dificuldade;
        this.experienciaEntregador = experienciaEntregador;
        this.experienciaAbrigo = experienciaAbrigo;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Abrigo getAbrigoOrigem() {
        return abrigoOrigem;
    }

    public void setAbrigoOrigem(Abrigo abrigoOrigem) {
        this.abrigoOrigem = abrigoOrigem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Integer getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Integer dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Integer getExperienciaEntregador() {
        return experienciaEntregador;
    }

    public void setExperienciaEntregador(Integer experienciaEntregador) {
        this.experienciaEntregador = experienciaEntregador;
    }

    public Integer getExperienciaAbrigo() {
        return experienciaAbrigo;
    }

    public void setExperienciaAbrigo(Integer experienciaAbrigo) {
        this.experienciaAbrigo = experienciaAbrigo;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "id=" + id +
                ", entregador=" + entregador +
                ", pessoa=" + pessoa +
                ", abrigoOrigem=" + abrigoOrigem +
                ", descricao='" + descricao + '\'' +
                ", peso=" + peso +
                ", status=" + status +
                ", dataPedido=" + dataPedido +
                ", dataInicio=" + dataInicio +
                ", dataConclusao=" + dataConclusao +
                ", dificuldade=" + dificuldade +
                ", experienciaEntregador=" + experienciaEntregador +
                ", experienciaAbrigo=" + experienciaAbrigo +
                '}';
    }
}
