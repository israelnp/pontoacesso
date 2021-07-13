package br.com.israel.pontoacesso.api.model.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class JornadaTrabalhoInput {

    @ApiModelProperty(example = "PJ", required = true)
    @NotBlank
    private String descricao;
}
