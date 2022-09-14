package br.com.desafio.serasaexperian.domain.dto.afinidade;

import br.com.desafio.serasaexperian.domain.enums.UF;
import br.com.desafio.serasaexperian.util.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AfinidadeDTO {

    @NotEmpty(message = Constants.MESSAGE_FILL + Constants.FIELD_REGION + Constants.MESSAGE_REQUIRE)
    @Length(min=3, max=120, message=Constants.LENGTH_FIELD)
    @ApiModelProperty(value = "Regiao da afinidade", example = "sudeste", required = true, position = 1)
    private String regiao;

    @NotEmpty(message = Constants.MESSAGE_FILL + Constants.FIELD_STATES + Constants.MESSAGE_REQUIRE)
    @ApiModelProperty(value = "Lista de estados da afinidade", example = "[ \"SP\",\"RJ\",\"MG\"]", required = true, position = 2)
    private Set<UF> estados;
}
