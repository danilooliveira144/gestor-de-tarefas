package posweb.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import posweb.tarefas.domain.Prioridade;
import posweb.tarefas.domain.Status;
import posweb.tarefas.domain.Tarefa;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByStatus(Status status);

    List<Tarefa> findByPrioridade(Prioridade prioridade);

    List<Tarefa> findByProjetoId(Long projetoId);

    List<Tarefa> findByResponsavelId(Long responsavelId);

    List<Tarefa> findByStatusAndPrioridade(
            Status status,
            Prioridade prioridade
    );

    List<Tarefa> findByStatusAndProjetoId(
            Status status,
            Long projetoId
    );

    List<Tarefa> findByStatusAndResponsavelId(
            Status status,
            Long responsavelId
    );

    List<Tarefa> findByPrioridadeAndProjetoId(
            Prioridade prioridade,
            Long projetoId
    );

    List<Tarefa> findByPrioridadeAndResponsavelId(
            Prioridade prioridade,
            Long responsavelId
    );

    List<Tarefa> findByProjetoIdAndResponsavelId(
            Long projetoId,
            Long responsavelId
    );

    List<Tarefa> findByStatusAndPrioridadeAndProjetoId(
            Status status,
            Prioridade prioridade,
            Long projetoId
    );

    List<Tarefa> findByStatusAndPrioridadeAndResponsavelId(
            Status status,
            Prioridade prioridade,
            Long responsavelId
    );

    List<Tarefa> findByStatusAndProjetoIdAndResponsavelId(
            Status status,
            Long projetoId,
            Long responsavelId
    );

    List<Tarefa> findByPrioridadeAndProjetoIdAndResponsavelId(
            Prioridade prioridade,
            Long projetoId,
            Long responsavelId
    );

    List<Tarefa> findByStatusAndPrioridadeAndProjetoIdAndResponsavelId(
            Status status,
            Prioridade prioridade,
            Long projetoId,
            Long responsavelId
    );
}