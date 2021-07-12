package br.com.israel.pontoacesso.model;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Calendario {

    private Long id;
    private TipoData tipoData;
    private String descricao;
    private LocalDateTime dataEspecial;
}
