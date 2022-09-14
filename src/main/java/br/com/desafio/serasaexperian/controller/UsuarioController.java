package br.com.desafio.serasaexperian.controller;

import br.com.desafio.serasaexperian.configuration.SwaggerConfiguration;
import br.com.desafio.serasaexperian.domain.dto.usuario.JwtDTO;
import br.com.desafio.serasaexperian.domain.dto.usuario.LoginDTO;
import br.com.desafio.serasaexperian.domain.dto.usuario.SignupDTO;
import br.com.desafio.serasaexperian.domain.dto.usuario.UserDTO;
import br.com.desafio.serasaexperian.service.UsuarioService;
import br.com.desafio.serasaexperian.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
@Api(tags = {SwaggerConfiguration.USER_TAG})
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/registrar")
    @ApiResponses(value = {
            @ApiResponse(code = Constants.STATUS_CODE_OK, message = Constants.API_RESPONSE_OK),
            @ApiResponse(code = Constants.STATUS_CODE_BAD_REQUEST, message = Constants.API_RESPONSE_BAD_REQUEST),
            @ApiResponse(code = Constants.STATUS_CODE_UNAUTHORIZED, message = Constants.API_RESPONSE_UNAUTHORIZED),
            @ApiResponse(code = Constants.STATUS_CODE_INTERNAL_ERROR_SERVER, message = Constants.API_RESPONSE_INTERNAL_ERROR_SERVER)
    })
    @ApiOperation(value = "Registra um novo usuário")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody SignupDTO signUpDTO) {
        log.info(Constants.LOG_KEY_MESSAGE + Constants.LOG_KEY_METHOD, Constants.LOG_MSG_START_REGISTER_USER, Constants.LOG_METHOD_REGISTER);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(signUpDTO).toUri()).body(usuarioService.register(signUpDTO));
    }

    @PostMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(code = Constants.STATUS_CODE_CREATED, message = Constants.API_RESPONSE_CREATED),
            @ApiResponse(code = Constants.STATUS_CODE_BAD_REQUEST, message = Constants.API_RESPONSE_BAD_REQUEST),
            @ApiResponse(code = Constants.STATUS_CODE_UNAUTHORIZED, message = Constants.API_RESPONSE_UNAUTHORIZED),
            @ApiResponse(code = Constants.STATUS_CODE_INTERNAL_ERROR_SERVER, message = Constants.API_RESPONSE_INTERNAL_ERROR_SERVER)
    })
    @ApiOperation(value = "Autentica um usuário existente")
    public ResponseEntity<JwtDTO> authenticate(@RequestBody LoginDTO loginDTO) {
        log.info(Constants.LOG_KEY_MESSAGE + Constants.LOG_KEY_METHOD, Constants.LOG_MSG_START_AUTHENTICATE_USER, Constants.LOG_METHOD_AUTHENTICATE);

        return ResponseEntity.ok(usuarioService.authenticate(loginDTO));
    }
}
