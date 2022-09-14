package br.com.desafio.serasaexperian.validator;

import br.com.desafio.serasaexperian.domain.dto.usuario.SignupDTO;
import br.com.desafio.serasaexperian.exception.FieldMessage;
import br.com.desafio.serasaexperian.repository.UsuarioRepository;
import br.com.desafio.serasaexperian.util.Constants;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static br.com.desafio.serasaexperian.util.Constants.PASSWORD_PATTERN;


@AllArgsConstructor
public class UserConstraintValidator implements ConstraintValidator<UserValidator, SignupDTO> {
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
    public boolean isValid(SignupDTO request, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (usuarioRepository.existsByEmail(request.getEmail())) {
            list.add(new FieldMessage("email", Constants.MESSAGE_DUPLICATED_EMAIL));
        }

        if (!validPassword(request.getSenha())){
            list.add(new FieldMessage("senha", Constants.MESSAGE_INVALID_PASSWORD));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}

