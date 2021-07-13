package br.com.israel.pontoacesso.domain.exception;

public class JornadaTrabalhoNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public JornadaTrabalhoNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public JornadaTrabalhoNaoEncontradaException(Long jornadaId) {
        this(String.format("Não existe um cadastro de jornada de trabalho com código %d", jornadaId));
    }
}
