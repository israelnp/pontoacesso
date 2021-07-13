package br.com.israel.pontoacesso.api.assembler;

import br.com.israel.pontoacesso.api.model.JornadaTrabalhoModel;
import br.com.israel.pontoacesso.domain.model.JornadaTrabalho;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JornadaTrabalhoAssembler  {

        @Autowired
        private ModelMapper modelMapper;

        public JornadaTrabalhoModel toModel(JornadaTrabalho jornadaTrabalho) {
            return modelMapper.map(jornadaTrabalho, JornadaTrabalhoModel.class);
        }

        public List<JornadaTrabalhoModel> paraListDeModel(List<JornadaTrabalho> jornadasTrabalho) {
            return jornadasTrabalho.stream().map(this::toModel).collect(Collectors.toList());
        }

    }
