package br.com.desafio.serasaexperian.domain.dto.score;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ScoreDTO {

    @ApiModelProperty(value = "Descrição do score", required = true, position = 1)
    @NotBlank
    private String scoreDescricao;

    @ApiModelProperty(value = "Valor inicial do score", required = true, position = 2)
    @Min(value = 0)
    @NotNull
    @JsonProperty("inicial")
    private Integer valorInicial;

    @ApiModelProperty(value = "Valor final do score", required = true, position = 3)
    @Max(value = 1000)
    @NotNull
    @JsonProperty("final")
    private Integer valorFinal;
}
