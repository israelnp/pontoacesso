package br.com.israel.pontoacesso.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class JornadaTrabalhoModel {

    @ApiModelProperty(example = "1")
    private long id;
    @ApiModelProperty(example = "PJ")
    private String descricao;
}
