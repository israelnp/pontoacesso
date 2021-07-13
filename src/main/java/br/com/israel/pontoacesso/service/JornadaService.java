package br.com.israel.pontoacesso.service;

import br.com.israel.pontoacesso.model.JornadaTrabalho;
import br.com.israel.pontoacesso.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JornadaService {

    JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public JornadaTrabalho salvarJornada(JornadaTrabalho jornadaTrabalho){
        return this.jornadaRepository.save(jornadaTrabalho);
    }

    public List<JornadaTrabalho> buscarTodasJornadas(){
        return this.jornadaRepository.findAll();
    }


}
