package br.com.israel.pontoacesso.api.assembler;

import br.com.israel.pontoacesso.api.model.input.JornadaTrabalhoInput;
import br.com.israel.pontoacesso.domain.model.JornadaTrabalho;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JornadaTrabalhoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public JornadaTrabalho toDomainObject(JornadaTrabalhoInput jornadaTrabalhoInput) {
        return modelMapper.map(jornadaTrabalhoInput, JornadaTrabalho.class);
    }
}
