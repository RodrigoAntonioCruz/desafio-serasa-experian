package br.com.desafio.serasaexperian.domain.dto.usuario;

import br.com.desafio.serasaexperian.domain.Perfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -3051421421219969734L;

    private String nome;

    private String email;

    private Set<Perfil> perfis;
}
