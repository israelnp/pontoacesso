package br.com.israel.pontoacesso.api.controller;

import br.com.israel.pontoacesso.api.assembler.JornadaTrabalhoInputDisassembler;
import br.com.israel.pontoacesso.api.assembler.JornadaTrabalhoAssembler;
import br.com.israel.pontoacesso.api.model.JornadaTrabalhoModel;
import br.com.israel.pontoacesso.domain.exception.JornadaTrabalhoNaoEncontradaException;
import br.com.israel.pontoacesso.domain.exception.NegocioException;
import br.com.israel.pontoacesso.domain.model.JornadaTrabalho;
import br.com.israel.pontoacesso.api.model.input.JornadaTrabalhoInput;
import br.com.israel.pontoacesso.domain.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/jornada", produces = MediaType.APPLICATION_JSON_VALUE)
public class JornadaTrabalhoController {

    JornadaService jornadaService;
    JornadaTrabalhoAssembler jornadaTrabalhoAssembler;
    JornadaTrabalhoInputDisassembler jornadaTrabalhoInputDisassembler;

    @Autowired
    public JornadaTrabalhoController(
                JornadaService jornadaService,
                JornadaTrabalhoAssembler jornadaTrabalhoAssembler,
                JornadaTrabalhoInputDisassembler jornadaTrabalhoInputDisassembler
            ) {
        this.jornadaService = jornadaService;
        this.jornadaTrabalhoAssembler = jornadaTrabalhoAssembler;
        this.jornadaTrabalhoInputDisassembler = jornadaTrabalhoInputDisassembler;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JornadaTrabalhoModel salvarJornada(@RequestBody @Valid JornadaTrabalhoInput jornadaTrabalhoInput){
        return this.jornadaTrabalhoAssembler.toModel(this.jornadaService
                .salvarJornada(this.jornadaTrabalhoInputDisassembler.toDomainObject(jornadaTrabalhoInput)));
    }

    @GetMapping
    public List<JornadaTrabalhoModel> buscarTodasJornadasDeTrabalho(){
        this.jornadaService.buscarTodasJornadas();
        return this.jornadaTrabalhoAssembler.paraListDeModel(this.jornadaService.buscarTodasJornadas());
    }

    @GetMapping("/{jornadaId}")
    public JornadaTrabalhoModel buscarJornadaDeTrabalhoPorId(@PathVariable Long jornadaId){
        return this.jornadaTrabalhoAssembler.toModel(this.jornadaService.buscarJornadaPorId(jornadaId));
    }

    @PutMapping("/{jornadaId}")
    public JornadaTrabalhoModel modificarJornadaDeTrabalho(@PathVariable Long jornadaId, @RequestBody @Valid JornadaTrabalhoInput jornadaTrabalhoInput){
        try {
            JornadaTrabalho jornadaAtual = this.jornadaService.buscarJornadaPorId(jornadaId);
            jornadaAtual.setDescricao(jornadaTrabalhoInput.getDescricao());
            jornadaAtual = this.jornadaService.salvarJornada(jornadaAtual);
            return this.jornadaTrabalhoAssembler.toModel(jornadaAtual);
        } catch (JornadaTrabalhoNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @DeleteMapping("/{jornadaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerJornadaDeTrabalhoPorId(@PathVariable Long jornadaId){
            jornadaService.removerJornadaPorId(jornadaId);
    }
}
