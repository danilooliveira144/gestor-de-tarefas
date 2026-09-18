package posweb.tarefas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import posweb.tarefas.domain.Prioridade;
import posweb.tarefas.domain.Status;
import posweb.tarefas.domain.Tarefa;
import posweb.tarefas.service.TarefaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa) {

        Tarefa tarefaSalva = service.salvar(tarefa);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tarefaSalva.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(tarefaSalva);
    }

    @GetMapping
    public List<Tarefa> listar(
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) Prioridade prioridade,
            @RequestParam(required = false) Long projetoId,
            @RequestParam(required = false) Long responsavelId) {

        return service.listar(
                status,
                prioridade,
                projetoId,
                responsavelId
        );
    }

    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(
            @PathVariable Long id,
            @RequestBody Tarefa tarefa) {

        return service.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}