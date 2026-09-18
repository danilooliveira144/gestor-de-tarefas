package posweb.tarefas.service;

import posweb.tarefas.domain.Responsavel;

import java.util.List;

public interface ResponsavelService {

    void cadastrarResponsavel(Responsavel responsavel);

    List<Responsavel> listarResponsaveisCadastrados();
}