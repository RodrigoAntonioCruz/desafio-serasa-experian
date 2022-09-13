package br.com.desafio.serasaexperian.domain.dto.afinidade;

import br.com.desafio.serasaexperian.domain.enums.UF;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
public class AfinidadeDTO {

    @NotBlank(message = "regiao é um campo obrigatorio")
    @ApiModelProperty(value = "Regiao da afinidade", example = "sudeste", required = true, position = 1)
    private String regiao;

    @NotEmpty(message = "Estados é um campo obrigatorio")
    @ApiModelProperty(value = "Lista de estados da afinidade", example = "[ \"SP\",\"RJ\",\"MG\"]", required = true, position = 2)
    private Set<UF> estados;
}
