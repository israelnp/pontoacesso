package br.com.israel.pontoacesso.domain.service;

import br.com.israel.pontoacesso.domain.model.JornadaTrabalho;
import br.com.israel.pontoacesso.domain.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

    public Optional<JornadaTrabalho> buscarJornadaPorId(Long jornadaId){
        return this.jornadaRepository.findById(jornadaId);
    }

    public JornadaTrabalho modificarJornada(JornadaTrabalho jornadaTrabalho){
        return this.jornadaRepository.save(jornadaTrabalho);
    }

    public void removerJornadaPorId(Long jornadaId){
         this.jornadaRepository.deleteById(jornadaId);
    }

}
