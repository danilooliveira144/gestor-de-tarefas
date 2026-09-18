package posweb.tarefas.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonPropertyOrder({
        "id",
        "titulo",
        "descricao",
        "status",
        "prioridade",
        "prazo",
        "criadaEm",
        "concluidaEm",
        "projeto",
        "responsavel"
})
@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    private LocalDate prazo;

    private LocalDateTime criadaEm;

    private LocalDateTime concluidaEm;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Projeto projeto;

    @ManyToOne
    private Responsavel responsavel;

    public Tarefa() {
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }

    public LocalDateTime getConcluidaEm() {
        return concluidaEm;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    @PrePersist
    public void aoCriar() {
        criadaEm = LocalDateTime.now();
    }

    @PreUpdate
    public void aoAtualizar() {

        if (status == Status.CONCLUIDA && concluidaEm == null) {
            concluidaEm = LocalDateTime.now();
        }
    }
}