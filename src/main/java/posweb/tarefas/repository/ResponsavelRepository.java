package posweb.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import posweb.tarefas.domain.Responsavel;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
}