package br.com.desafio.serasaexperian.domain.dto.usuario.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginRequest implements Serializable {
	private static final long serialVersionUID = 7086810874058978087L;

	@ApiModelProperty(value = "E-mail do usuário", example = "rodrigo@msn.com", required = true, position = 1)
	private String email;

	@ApiModelProperty(value = "Senha do usuário", example = "123Aa$Aa", required = true, position = 2)
	private String senha;
}
