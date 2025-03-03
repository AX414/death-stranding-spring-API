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
    @JoinColumn(name = "remetente_id")
    private Pessoa remetente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    private Pessoa destinatario;

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
    private Integer experiencia;

    public Entrega() {
    }

    public Entrega(UUID id, Long version, Entregador entregador, Pessoa remetente, Pessoa destinatario, String descricao, Double peso, StatusEntrega status, LocalDate dataPedido, LocalDate dataInicio, LocalDate dataConclusao, Integer dificuldade, Integer experiencia) {
        this.id = id;
        this.version = version;
        this.entregador = entregador;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.descricao = descricao;
        this.peso = peso;
        this.status = status;
        this.dataPedido = dataPedido;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.dificuldade = dificuldade;
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

    public Pessoa getRemetente() {
        return remetente;
    }

    public void setRemetente(Pessoa remetente) {
        this.remetente = remetente;
    }

    public Pessoa getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Pessoa destinatario) {
        this.destinatario = destinatario;
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

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "ENTREGA -> | UUID:"+id+
                " | Entregador: "+(entregador != null ? entregador.getNome() : "Sem entregador")+
                " | Remetente: "+remetente.getNome()+
                " | Destinatário: "+destinatario.getNome()+
                " | Descrição: "+descricao+
                " | Peso (KG): "+peso+
                " | Status: "+status+
                " | Data do pedido: "+dataPedido+
                " | Data de Início: "+dataInicio+
                " | Data de Conclusão: "+dataConclusao+
                " | Dificuldade (1-5): "+dificuldade+
                " | Experiência: "+experiencia+
                " |";
    }
}