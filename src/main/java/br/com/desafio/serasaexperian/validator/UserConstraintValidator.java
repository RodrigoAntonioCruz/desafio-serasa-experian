package br.com.desafio.serasaexperian.validator;

import br.com.desafio.serasaexperian.domain.dto.usuario.request.SignupRequest;
import br.com.desafio.serasaexperian.exception.ExceptionOf;
import br.com.desafio.serasaexperian.exception.ExceptionResolver;
import br.com.desafio.serasaexperian.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static br.com.desafio.serasaexperian.util.Constants.PASSWORD_PATTERN;


@AllArgsConstructor
public class UserConstraintValidator implements ConstraintValidator<UserValidator, SignupRequest> {
    private final UsuarioRepository usuarioRepository;
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    public void initialize(UserValidator ann) {
    }
    private boolean validPassword(String senha) {
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }

    @Override
    public boolean isValid(SignupRequest request, ConstraintValidatorContext context) {
        List<ExceptionResolver> list = new ArrayList<>();

        if (usuarioRepository.existsByEmail(request.getEmail())) {
            list.add(new ExceptionResolver("email", ExceptionOf.DUPLICATED_EMAIL.getMessage()));
        }

        if (!validPassword(request.getSenha())){
            list.add(new ExceptionResolver("senha", ExceptionOf.INVALID_PASSWORD.getMessage()));
        }

        for (ExceptionResolver e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                   .addPropertyNode(e.getField()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}

