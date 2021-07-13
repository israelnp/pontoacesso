package br.com.israel.pontoacesso.api.controller;

import br.com.israel.pontoacesso.domain.model.JornadaTrabalho;
import br.com.israel.pontoacesso.domain.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    JornadaService jornadaService;

    @Autowired
    public JornadaTrabalhoController(JornadaService jornadaService) {
        this.jornadaService = jornadaService;
    }

    @PostMapping
    public JornadaTrabalho salvar(@RequestBody JornadaTrabalho jornadaTrabalho){
        return this.jornadaService.salvarJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> buscarTodasJornadasDeTrabalho(){
        return this.jornadaService.buscarTodasJornadas();
    }

    @GetMapping("/{jornadaId}")
    public ResponseEntity<JornadaTrabalho> buscarJornadaDeTrabalhoPorId(@PathVariable Long jornadaId){
        return ResponseEntity.ok(this.jornadaService.buscarJornadaPorId(jornadaId)
                .orElseThrow(() -> new NoSuchElementException("Não Encontrado!")));
    }

    @PutMapping
    public JornadaTrabalho modificarJornadaDeTrabalho(@RequestBody JornadaTrabalho jornadaTrabalho){
        return this.jornadaService.modificarJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{jornadaId}")
    public ResponseEntity removerJornadaDeTrabalhoPorId(@PathVariable Long jornadaId){
        try {
            jornadaService.removerJornadaPorId(jornadaId);
        }catch (Exception e){
           e.printStackTrace();
        }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();
    }
}