package br.com.desafio.serasaexperian.exception;

import br.com.desafio.serasaexperian.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionOf {

    UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value() + "," + Constants.ERROR_UNAUTHORIZED + "," + Constants.MESSAGE_UNAUTHORIZED),

    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED.value() + "," + Constants.ERROR_UNAUTHORIZED + "," + Constants.MESSAGE_INVALID_CREDENTIALS),

    FORBIDDEN(HttpStatus.FORBIDDEN.value() + "," + Constants.ERROR_FORBIDDEN + "," + Constants.MESSAGE_FORBIDDEN),
    DUPLICATED_EMAIL(HttpStatus.CONFLICT.value() + "," + Constants.ERROR_DUPLICATED_EMAIL + "," + Constants.MESSAGE_DUPLICATED_EMAIL),
    INVALID_PROFILE(HttpStatus.BAD_REQUEST.value() + "," + Constants.ERROR_INVALID_PROFILE + "," + Constants.MESSAGE_INVALID_PROFILE),
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST.value() + "," + Constants.ERROR_INVALID_PASSWORD + "," + Constants.MESSAGE_INVALID_PASSWORD),
    INVALID_JWT_SIGNATURE(HttpStatus.BAD_REQUEST.value() + "," + Constants.ERROR_VALIDATION + "," + Constants.MESSAGE_INVALID_JWT_SIGNATURE),
    INVALID_JWT_TOKEN(HttpStatus.BAD_REQUEST.value() + "," + Constants.ERROR_VALIDATION + "," + Constants.MESSAGE_INVALID_JWT_TOKEN),
    EXPIRED_JWT_TOKEN(HttpStatus.BAD_REQUEST.value() + "," + Constants.ERROR_VALIDATION + "," + Constants.MESSAGE_EXPIRED_JWT_TOKEN),
    UNSUPPORTED_JWT_TOKEN(HttpStatus.BAD_REQUEST.value() + "," + Constants.ERROR_VALIDATION + "," + Constants.MESSAGE_UNSUPPORTED_JWT_TOKEN),
    EMPTY_JWT_TOKEN(HttpStatus.BAD_REQUEST.value() + "," + Constants.ERROR_VALIDATION + "," + Constants.MESSAGE_EMPTY_JWT_TOKEN);

    private final String message;

    public BusinessException message(){
        return BusinessException.builder().message(String.format(this.message)).build();
    }
}
