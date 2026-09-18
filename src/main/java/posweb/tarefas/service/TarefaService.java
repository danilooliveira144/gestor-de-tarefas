package posweb.tarefas.service;

import org.springframework.stereotype.Service;
import posweb.tarefas.domain.*;
import posweb.tarefas.exception.RecursoNaoEncontradoException;
import posweb.tarefas.repository.ProjetoRepository;
import posweb.tarefas.repository.ResponsavelRepository;
import posweb.tarefas.repository.TarefaRepository;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;
    private final ProjetoRepository projetoRepository;
    private final ResponsavelRepository responsavelRepository;

    public TarefaService(
            TarefaRepository repository,
            ProjetoRepository projetoRepository,
            ResponsavelRepository responsavelRepository) {

        this.repository = repository;
        this.projetoRepository = projetoRepository;
        this.responsavelRepository = responsavelRepository;
    }

    public Tarefa salvar(Tarefa tarefa) {

        if (tarefa.getStatus() == null) {
            tarefa.setStatus(Status.NOVA);
        }

        if (tarefa.getPrioridade() == null) {
            tarefa.setPrioridade(Prioridade.MEDIA);
        }

        if (tarefa.getProjeto() == null) {
            throw new RecursoNaoEncontradoException("Projeto é obrigatório");
        }

        Long projetoId = tarefa.getProjeto().getId();

        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Projeto não encontrado"));

        tarefa.setProjeto(projeto);

        if (tarefa.getResponsavel() != null) {

            Long responsavelId = tarefa.getResponsavel().getId();

            Responsavel responsavel = responsavelRepository.findById(responsavelId)
                    .orElseThrow(() ->
                            new RecursoNaoEncontradoException("Responsável não encontrado"));

            tarefa.setResponsavel(responsavel);
        }

        return repository.save(tarefa);
    }

    public List<Tarefa> listar(
            Status status,
            Prioridade prioridade,
            Long projetoId,
            Long responsavelId) {

        if (status != null && prioridade != null && projetoId != null && responsavelId != null) {
            return repository.findByStatusAndPrioridadeAndProjetoIdAndResponsavelId(
                    status, prioridade, projetoId, responsavelId);
        }

        if (status != null && prioridade != null && projetoId != null) {
            return repository.findByStatusAndPrioridadeAndProjetoId(
                    status, prioridade, projetoId);
        }

        if (status != null && prioridade != null && responsavelId != null) {
            return repository.findByStatusAndPrioridadeAndResponsavelId(
                    status, prioridade, responsavelId);
        }

        if (status != null && projetoId != null && responsavelId != null) {
            return repository.findByStatusAndProjetoIdAndResponsavelId(
                    status, projetoId, responsavelId);
        }

        if (prioridade != null && projetoId != null && responsavelId != null) {
            return repository.findByPrioridadeAndProjetoIdAndResponsavelId(
                    prioridade, projetoId, responsavelId);
        }

        if (status != null && prioridade != null) {
            return repository.findByStatusAndPrioridade(status, prioridade);
        }

        if (status != null && projetoId != null) {
            return repository.findByStatusAndProjetoId(status, projetoId);
        }

        if (status != null && responsavelId != null) {
            return repository.findByStatusAndResponsavelId(status, responsavelId);
        }

        if (prioridade != null && projetoId != null) {
            return repository.findByPrioridadeAndProjetoId(prioridade, projetoId);
        }

        if (prioridade != null && responsavelId != null) {
            return repository.findByPrioridadeAndResponsavelId(
                    prioridade, responsavelId);
        }

        if (projetoId != null && responsavelId != null) {
            return repository.findByProjetoIdAndResponsavelId(
                    projetoId, responsavelId);
        }

        if (status != null) {
            return repository.findByStatus(status);
        }

        if (prioridade != null) {
            return repository.findByPrioridade(prioridade);
        }

        if (projetoId != null) {
            return repository.findByProjetoId(projetoId);
        }

        if (responsavelId != null) {
            return repository.findByResponsavelId(responsavelId);
        }

        return repository.findAll();
    }

    public Tarefa buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Tarefa não encontrada"));
    }

    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {

        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Tarefa não encontrada"));

        tarefa.setTitulo(tarefaAtualizada.getTitulo());
        tarefa.setDescricao(tarefaAtualizada.getDescricao());
        tarefa.setStatus(tarefaAtualizada.getStatus());
        tarefa.setPrioridade(tarefaAtualizada.getPrioridade());
        tarefa.setPrazo(tarefaAtualizada.getPrazo());

        if (tarefaAtualizada.getProjeto() != null) {

            Long projetoId = tarefaAtualizada.getProjeto().getId();

            Projeto projeto = projetoRepository.findById(projetoId)
                    .orElseThrow(() ->
                            new RecursoNaoEncontradoException("Projeto não encontrado"));

            tarefa.setProjeto(projeto);
        }

        if (tarefaAtualizada.getResponsavel() != null) {

            Long responsavelId = tarefaAtualizada.getResponsavel().getId();

            Responsavel responsavel = responsavelRepository.findById(responsavelId)
                    .orElseThrow(() ->
                            new RecursoNaoEncontradoException("Responsável não encontrado"));

            tarefa.setResponsavel(responsavel);

        } else {

            tarefa.setResponsavel(null);
        }

        return repository.save(tarefa);
    }

    public void excluir(Long id) {

        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Tarefa não encontrada"));

        repository.delete(tarefa);
    }
}