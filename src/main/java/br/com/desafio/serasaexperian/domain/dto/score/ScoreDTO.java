package br.com.desafio.serasaexperian.domain.dto.score;

import br.com.desafio.serasaexperian.util.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDTO {

    @NotEmpty(message = Constants.MESSAGE_FILL + Constants.FIELD_REGION + Constants.MESSAGE_REQUIRE)
    @Length(min=3, max=120, message=Constants.LENGTH_FIELD)
    @ApiModelProperty(value = "Descrição do score", required = true, position = 1)
    private String scoreDescricao;

    @JsonProperty("inicial")
    @NotNull(message = Constants.MESSAGE_FILL + Constants.FIELD_SCORE_MIN + Constants.MESSAGE_REQUIRE)
    @Min(value = 0, message=Constants.LENGTH_MIN_SCORE)
    @ApiModelProperty(value = "Valor inicial do score", required = true, position = 2)
    private Integer valorInicial;

    @JsonProperty("final")
    @NotNull(message = Constants.MESSAGE_FILL + Constants.FIELD_SCORE_MAX + Constants.MESSAGE_REQUIRE)
    @Max(value = 1000, message=Constants.LENGTH_MAX_SCORE)
    @ApiModelProperty(value = "Valor final do score", required = true, position = 3)
    private Integer valorFinal;
}
