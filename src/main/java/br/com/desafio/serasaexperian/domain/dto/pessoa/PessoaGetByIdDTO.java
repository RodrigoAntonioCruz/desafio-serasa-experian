package br.com.desafio.serasaexperian.domain.dto.pessoa;

import br.com.desafio.serasaexperian.domain.enums.UF;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Set;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PessoaGetByIdDTO {

    @ApiModelProperty(value = "nome da pessoa", required = true, position = 1)
    private String nome;

    @ApiModelProperty(value = "telefone da pessoa", required = true, position = 2)
    private String telefone;

    @ApiModelProperty(value = "Idade da pessoa", required = true, position = 3)
    private Integer idade;

    @ApiModelProperty(value = "scoreDescricao da pessoa", required = true, position = 4)
    private String scoreDescricao;

    @ApiModelProperty(value = "estado da pessoa", required = true, position = 5)
    private Set<UF> estados;

}
