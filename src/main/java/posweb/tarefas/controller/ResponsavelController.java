package posweb.tarefas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import posweb.tarefas.domain.Responsavel;
import posweb.tarefas.service.ResponsavelService;

import java.util.List;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {

    private final ResponsavelService service;

    public ResponsavelController(ResponsavelService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarResponsavel(
            @RequestBody Responsavel responsavel) {

        service.cadastrarResponsavel(responsavel);
    }

    @GetMapping
    public List<Responsavel> listarTodos() {
        return service.listarResponsaveisCadastrados();
    }
}