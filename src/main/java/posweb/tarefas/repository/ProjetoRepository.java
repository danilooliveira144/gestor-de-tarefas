package posweb.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import posweb.tarefas.domain.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}