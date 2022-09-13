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
public class PessoaGetAllDTO {

    @ApiModelProperty(value = "Nome da pessoa", example = "Ana Maria Silva", required = true, position = 1)
    private String nome;

    @ApiModelProperty(value = "Cidade da pessoa", example = "Rio de Janeiro", required = true, position = 2)
    private String cidade;

    @ApiModelProperty(value = "Unidade Federativa de residencia da pessoa", example = "RJ", required = true, position = 3)
    private UF estado;

    @ApiModelProperty(value = "Valor do score da pessoa", example = "562", required = true, position = 4)
    private String scoreDescricao;

    @ApiModelProperty(value = "Lista de estados da afinidade", example = "[ \"SP\",\"RJ\",\"MG\"]", required = true, position = 5)
    private Set<UF> estados;

}
