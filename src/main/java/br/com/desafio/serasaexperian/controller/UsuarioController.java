package br.com.desafio.serasaexperian.controller;

import br.com.desafio.serasaexperian.configuration.SwaggerConfiguration;
import br.com.desafio.serasaexperian.domain.dto.usuario.request.LoginRequest;
import br.com.desafio.serasaexperian.domain.dto.usuario.request.SignupRequest;
import br.com.desafio.serasaexperian.domain.dto.usuario.response.JwtResponse;
import br.com.desafio.serasaexperian.domain.dto.usuario.response.UserResponse;
import br.com.desafio.serasaexperian.service.UsuarioService;
import br.com.desafio.serasaexperian.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
@Api(tags = {SwaggerConfiguration.USER_TAG})
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Constants.API_RESPONSE_OK),
            @ApiResponse(code = 400, message = Constants.API_RESPONSE_BAD_REQUEST),
            @ApiResponse(code = 401, message = Constants.API_RESPONSE_UNAUTHORIZED),
            @ApiResponse(code = 500, message = Constants.API_RESPONSE_INTERNAL_ERROR_SERVER)
    })
    @ApiOperation(value = "Autentica um usuário existente")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(usuarioService.authenticate(loginRequest));
    }

    @PostMapping("/registrar")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = Constants.API_RESPONSE_CREATED),
            @ApiResponse(code = 400, message = Constants.API_RESPONSE_BAD_REQUEST),
            @ApiResponse(code = 401, message = Constants.API_RESPONSE_UNAUTHORIZED),
            @ApiResponse(code = 500, message = Constants.API_RESPONSE_INTERNAL_ERROR_SERVER)
    })
    @ApiOperation(value = "Registra um novo usuário")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(signUpRequest).toUri()).body(usuarioService.register(signUpRequest));
    }
}
