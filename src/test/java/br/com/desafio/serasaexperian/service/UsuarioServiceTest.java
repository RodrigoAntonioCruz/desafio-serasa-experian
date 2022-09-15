package br.com.desafio.serasaexperian.service;

import br.com.desafio.serasaexperian.domain.Perfil;
import br.com.desafio.serasaexperian.domain.Usuario;
import br.com.desafio.serasaexperian.factory.ScenarioFactory;
import br.com.desafio.serasaexperian.repository.UsuarioRepository;
import br.com.desafio.serasaexperian.security.JwtTokenProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest extends ScenarioFactory {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private PasswordEncoder pwd;

    @Mock
    private JwtTokenProvider tokenProvider;
    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private AuthenticationManager authenticationManager;


    @Before
    public void setup() {

        TOKEN_JWT = getToken();

        LOGIN_DTO = getLoginDTO();

        SIGNUP_DTO = getSignupDTO();

        USER_DTO = getUserDTO();

        USUARIO = getUsuario();

        when(usuarioRepository.save(USUARIO)).thenReturn(USUARIO);

        when(mapper.map(SIGNUP_DTO, Usuario.class)).thenReturn(USUARIO);

        when(tokenProvider.generateToken(any())).thenReturn(TOKEN_JWT);

   }

    @Test
    @DisplayName("Testa a registro de um novo usuário")
    public void when_register_user_return_success(){

        var usuario = usuarioService.register(SIGNUP_DTO);

        Assert.assertEquals(usuario.getNome(), USER_DTO.getNome());
        Assert.assertEquals(usuario.getEmail(), USER_DTO.getEmail());
        Assert.assertEquals(usuario.getPerfis().stream().map(Perfil::getNome).findFirst(),
                USER_DTO.getPerfis().stream().map(Perfil::getNome).findFirst());
    }


    @Test
    @DisplayName("Testa a autenticação de um usuário retornando um token")
    public void when_authenticate_user_return_token_bearer_success(){

        var token = usuarioService.authenticate(LOGIN_DTO);

        Assert.assertEquals(token.getToken(), "Bearer " + TOKEN_JWT);
    }

}
