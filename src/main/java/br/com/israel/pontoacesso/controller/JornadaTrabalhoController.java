package br.com.israel.pontoacesso.controller;

import br.com.israel.pontoacesso.model.JornadaTrabalho;
import br.com.israel.pontoacesso.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
