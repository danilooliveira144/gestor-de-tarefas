package posweb.tarefas.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@JsonPropertyOrder({
        "id",
        "nome",
        "descricao"
})
@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    public Projeto() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}