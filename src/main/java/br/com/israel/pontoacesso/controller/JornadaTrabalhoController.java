package br.com.israel.pontoacesso.controller;

import br.com.israel.pontoacesso.model.JornadaTrabalho;
import br.com.israel.pontoacesso.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public JornadaTrabalho salvar(@RequestBody JornadaTrabalho jornadaTrabalho){
        return this.jornadaService.salvarJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> buscarTodasJornadasDeTrabalho(){
        return this.jornadaService.buscarTodasJornadas();
    }
}
