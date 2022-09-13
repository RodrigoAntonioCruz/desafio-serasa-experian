package br.com.desafio.serasaexperian.domain.dto.usuario;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtDTO implements Serializable {
	private static final long serialVersionUID = -3013893615498524385L;
	private String token;
	public JwtDTO(String accessToken) {
		this.token = "Bearer " + accessToken;
	}
}
