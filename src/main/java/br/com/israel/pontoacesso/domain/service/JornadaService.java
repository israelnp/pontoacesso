package br.com.israel.pontoacesso.domain.service;

import br.com.israel.pontoacesso.domain.exception.EntidadeEmUsoException;
import br.com.israel.pontoacesso.domain.exception.JornadaTrabalhoNaoEncontradaException;
import br.com.israel.pontoacesso.domain.model.JornadaTrabalho;
import br.com.israel.pontoacesso.domain.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JornadaService {

    private static final String MSG_JORNADA_EM_USO
            = "Jornada de código %d não pode ser removida, pois está em uso";

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

    public JornadaTrabalho buscarJornadaPorId(Long jornadaId){
        return this.jornadaRepository.findById(jornadaId)
                .orElseThrow(() -> new JornadaTrabalhoNaoEncontradaException(jornadaId));
    }

    public void removerJornadaPorId(Long jornadaId){
        try {
            this.jornadaRepository.deleteById(jornadaId);
            this.jornadaRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new JornadaTrabalhoNaoEncontradaException(jornadaId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_JORNADA_EM_USO, jornadaId));
        }

    }

}
