package posweb.tarefas.service;

import org.springframework.stereotype.Service;
import posweb.tarefas.domain.Projeto;
import posweb.tarefas.exception.RecursoNaoEncontradoException;
import posweb.tarefas.repository.ProjetoRepository;

import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository repository;

    public ProjetoService(ProjetoRepository repository) {
        this.repository = repository;
    }

    public Projeto salvar(Projeto projeto) {
        return repository.save(projeto);
    }

    public List<Projeto> listar() {
        return repository.findAll();
    }

    public Projeto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Projeto não encontrado"));
    }
}