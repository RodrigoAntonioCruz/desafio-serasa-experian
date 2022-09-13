package br.com.desafio.serasaexperian.domain.dto.usuario;


import br.com.desafio.serasaexperian.util.Constants;
import br.com.desafio.serasaexperian.validator.UserValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Data
@Builder
@UserValidator
@NoArgsConstructor
@AllArgsConstructor
public class SignupDTO implements Serializable {
    private static final long serialVersionUID = 6016806597527015535L;

    @NotEmpty(message = Constants.MESSAGE_FILL + Constants.FIELD_NAME + Constants.MESSAGE_REQUIRE)
    @Length(min=3, max=120, message=Constants.LENGTH_FIELD)
    @ApiModelProperty(value = "Nome completo do usuário", example = "Rodrigo Antonio Cruz", required = true, position = 1)
    private String nome;

    @Email(message = Constants.ERROR_INVALID_EMAIL)
    @NotEmpty(message = Constants.MESSAGE_FILL + Constants.FIELD_EMAIL + Constants.MESSAGE_REQUIRE)
    @ApiModelProperty(value = "E-mail do usuário", example = "rodrigo@msn.com", required = true, position = 2)
    private String email;

    @ApiModelProperty(value = "Senha do usuário", example = "123Aa$Aa", required = true, position = 3)
    private String senha;
}