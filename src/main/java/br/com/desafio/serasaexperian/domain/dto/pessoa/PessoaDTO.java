package br.com.desafio.serasaexperian.domain.dto.pessoa;

import br.com.desafio.serasaexperian.domain.enums.UF;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PessoaDTO {

    @NotBlank(message = "nome é um campo obrigatorio")
    @ApiModelProperty(value = "Nome da pessoa", example = "Ana Maria Silva", required = true, position = 1)
    private String nome;

    @NotBlank(message = "telefone é um campo obrigatorio")
    @ApiModelProperty(value = "Telefone da pessoa", example = "51996653355", required = true, position = 2)
    private String telefone;

    @NotNull(message = "idade é um campo obrigatorio")
    @ApiModelProperty(value = "Idade da pessoa", example = "31", required = true, position = 3)
    private Integer idade;

    @NotBlank(message = "cidade é um campo obrigatorio")
    @ApiModelProperty(value = "Cidade da pessoa", example = "Rio de Janeiro", required = true, position = 4)
    private String cidade;

    @ApiModelProperty(value = "Unidade Federativa de residencia da pessoa", example = "RJ", required = true, position = 5)
    @NotNull(message = "estado é um campo obrigatorio")
    private UF estado;

    @ApiModelProperty(value = "Região geográfica da pessoa", example = "sudeste", required = true, position = 6)
    @NotBlank(message = "regiao é um campo obrigatorio")
    private String regiao;

    @ApiModelProperty(value = "Valor do score da pessoa", example = "562", required = true, position = 7)
    @NotNull(message = "score é um campo obrigatorio")
    @Max(value = 1000, message = "valor maximo 1000")
    @Min(value = 0, message = "valor minimo 0")
    private Integer score;
}
