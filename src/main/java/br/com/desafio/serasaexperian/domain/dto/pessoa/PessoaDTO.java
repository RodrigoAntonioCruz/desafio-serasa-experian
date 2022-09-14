package br.com.desafio.serasaexperian.domain.dto.pessoa;

import br.com.desafio.serasaexperian.domain.enums.UF;
import br.com.desafio.serasaexperian.util.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    @NotEmpty(message = Constants.MESSAGE_FILL + Constants.FIELD_NAME + Constants.MESSAGE_REQUIRE)
    @Length(min=3, max=120, message=Constants.LENGTH_FIELD)
    @ApiModelProperty(value = "Nome da pessoa", example = "Ana Maria Silva", required = true, position = 1)
    private String nome;

    @NotEmpty(message = Constants.MESSAGE_FILL + Constants.FIELD_PHONE + Constants.MESSAGE_REQUIRE)
    @ApiModelProperty(value = "Telefone da pessoa", example = "51996653355", required = true, position = 2)
    private String telefone;

    @NotNull(message = Constants.MESSAGE_FILL + Constants.FIELD_AGE + Constants.MESSAGE_REQUIRE)
    @Positive(message = Constants.POSITIVE_AGE)
    @ApiModelProperty(value = "Idade da pessoa", example = "31", required = true, position = 3)
    private Integer idade;

    @NotEmpty(message = Constants.MESSAGE_FILL + Constants.FIELD_CITY + Constants.MESSAGE_REQUIRE)
    @Length(min=3, max=120, message=Constants.LENGTH_FIELD)
    @ApiModelProperty(value = "Cidade da pessoa", example = "Rio de Janeiro", required = true, position = 4)
    private String cidade;

    @ApiModelProperty(value = "Unidade Federativa de residencia da pessoa", example = "RJ", required = true, position = 5)
    private UF estado;

    @NotEmpty(message = Constants.MESSAGE_FILL + Constants.FIELD_REGION + Constants.MESSAGE_REQUIRE)
    @Length(min=3, max=120, message=Constants.LENGTH_FIELD)
    @ApiModelProperty(value = "Região geográfica da pessoa", example = "sudeste", required = true, position = 6)
    private String regiao;

    @NotNull(message = Constants.MESSAGE_FILL + Constants.FIELD_SCORE + Constants.MESSAGE_REQUIRE)
    @Min(value = 0, message=Constants.LENGTH_MIN_SCORE)
    @Max(value = 1000, message=Constants.LENGTH_MAX_SCORE)
    @ApiModelProperty(value = "Valor do score da pessoa", example = "562", required = true, position = 7)
    private Integer score;
}
