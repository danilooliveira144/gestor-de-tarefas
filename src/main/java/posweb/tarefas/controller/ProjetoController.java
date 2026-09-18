package posweb.tarefas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import posweb.tarefas.domain.Projeto;
import posweb.tarefas.service.ProjetoService;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService service;

    public ProjetoController(ProjetoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Projeto criar(@RequestBody Projeto projeto) {
        return service.salvar(projeto);
    }

    @GetMapping
    public List<Projeto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Projeto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}