package br.com.israel.pontoacesso.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class BancoHoras {

    @EqualsAndHashCode
    @Getter
    @Setter
    public  class BancoHorasId implements Serializable {
        private long idBancoHoras;
        private long idMovimentacao;
        private long idUsuario;


    }

    private BancoHorasId bancoHorasId;
    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;
}
