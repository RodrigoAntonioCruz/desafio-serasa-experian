package br.com.desafio.serasaexperian.exception;

import br.com.desafio.serasaexperian.util.Constants;
import static br.com.desafio.serasaexperian.exception.BusinessException.of;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
        List<String> messages = splitMessage(Objects.requireNonNull(e.getBindingResult().getFieldErrors().get(0).getDefaultMessage()));

        if (StringUtils.isNumeric(messages.get(0))) {
            return getException(HttpStatus.valueOf(Integer.parseInt(messages.get(0))), messages.get(1), messages.get(2), request.getRequestURI());
        }

        return getException(HttpStatus.BAD_REQUEST, Constants.ERROR_VALIDATION, messages.get(0), request.getRequestURI());

    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> validation(Throwable e, HttpServletRequest request) {
        List<String> messages = splitMessage(e.getMessage());
        return getException(HttpStatus.valueOf(Integer.parseInt(messages.get(0))), messages.get(1), messages.get(2), request.getRequestURI());
    }

    private ResponseEntity<Object> getException(HttpStatus httpStatus, String error, String message, String path) {
        return ResponseEntity.status(httpStatus.value()).body(of(httpStatus.value(), error, message, path));
    }

    private List<String> splitMessage(String message) {
        return Stream.of(Objects.requireNonNull(message).split(",", -1)).collect(Collectors.toList());
    }
}
