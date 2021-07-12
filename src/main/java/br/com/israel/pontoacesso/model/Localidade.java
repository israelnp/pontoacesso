package br.com.israel.pontoacesso.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Localidade {

    private  long id;
    private NivelAcesso nivelAcesso;
    private String descricao;
}
