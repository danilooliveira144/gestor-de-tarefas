package posweb.tarefas.service;

import org.springframework.stereotype.Service;
import posweb.tarefas.domain.Responsavel;
import posweb.tarefas.repository.ResponsavelRepository;

import java.util.List;

@Service
public class ResponsavelServiceImpl implements ResponsavelService {

    private final ResponsavelRepository repository;

    public ResponsavelServiceImpl(ResponsavelRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrarResponsavel(Responsavel responsavel) {
        repository.save(responsavel);
    }

    @Override
    public List<Responsavel> listarResponsaveisCadastrados() {
        return repository.findAll();
    }
}