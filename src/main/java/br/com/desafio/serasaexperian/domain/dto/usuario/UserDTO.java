package br.com.desafio.serasaexperian.domain.dto.usuario;

import br.com.desafio.serasaexperian.domain.Perfil;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -3051421421219969734L;

    private String nome;

    private String email;

    private Set<Perfil> perfis;
}
