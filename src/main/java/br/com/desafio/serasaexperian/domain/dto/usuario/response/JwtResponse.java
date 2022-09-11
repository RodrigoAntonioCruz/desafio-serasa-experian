package br.com.desafio.serasaexperian.domain.dto.usuario.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -3013893615498524385L;
	private String token;
	public JwtResponse(String accessToken) {
		this.token = "Bearer " + accessToken;
	}
}
