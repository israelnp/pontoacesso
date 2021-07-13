package br.com.israel.pontoacesso.api.controller;

import br.com.israel.pontoacesso.domain.exception.JornadaTrabalhoNaoEncontradaException;
import br.com.israel.pontoacesso.domain.exception.NegocioException;
import br.com.israel.pontoacesso.domain.model.JornadaTrabalho;
import br.com.israel.pontoacesso.domain.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    JornadaService jornadaService;


    @Autowired
    public JornadaTrabalhoController(JornadaService jornadaService) {
        this.jornadaService = jornadaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JornadaTrabalho salvarJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return this.jornadaService.salvarJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> buscarTodasJornadasDeTrabalho(){
        return this.jornadaService.buscarTodasJornadas();
    }

    @GetMapping("/{jornadaId}")
    public JornadaTrabalho buscarJornadaDeTrabalhoPorId(@PathVariable Long jornadaId){
        return this.jornadaService.buscarJornadaPorId(jornadaId);
    }

    @PutMapping
    public JornadaTrabalho modificarJornadaDeTrabalho(@RequestBody JornadaTrabalho jornadaTrabalho){
        try {
            JornadaTrabalho jornadaAtual = this.jornadaService.buscarJornadaPorId(jornadaTrabalho.getId());

            jornadaAtual.setDescricao(jornadaTrabalho.getDescricao());

            jornadaAtual = this.jornadaService.salvarJornada(jornadaAtual);

            return jornadaAtual;
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
