package br.com.desafio.serasaexperian.service;

import br.com.desafio.serasaexperian.domain.Usuario;
import br.com.desafio.serasaexperian.domain.dto.usuario.JwtDTO;
import br.com.desafio.serasaexperian.domain.dto.usuario.LoginDTO;
import br.com.desafio.serasaexperian.domain.dto.usuario.SignupDTO;
import br.com.desafio.serasaexperian.domain.dto.usuario.UserDTO;
import br.com.desafio.serasaexperian.domain.enums.Perfil;
import br.com.desafio.serasaexperian.repository.UsuarioRepository;
import br.com.desafio.serasaexperian.security.JwtTokenProvider;
import br.com.desafio.serasaexperian.util.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
@Slf4j
@Service
@AllArgsConstructor
public class UsuarioService {
    private final ModelMapper mapper;
    private final PasswordEncoder pwd;
    private JwtTokenProvider tokenProvider;
    private final UsuarioRepository usuarioRepository;
    private AuthenticationManager authenticationManager;

    public UserDTO register(SignupDTO request) {
        log.info(Constants.LOG_KEY_MESSAGE + Constants.LOG_KEY_METHOD , Constants.LOG_MSG_START_REGISTER_USER, Constants.LOG_METHOD_REGISTER);

        Usuario usuario = mapper.map(request, Usuario.class);
        usuario.setSenha(pwd.encode(request.getSenha()));

        usuario.setPerfis(Set.of(br.com.desafio.serasaexperian.domain.Perfil.builder().nome(String.valueOf(Perfil.ROLE_USER)).build()));
        return mapper.map(usuarioRepository.save(usuario), UserDTO.class);
    }

    public JwtDTO authenticate(LoginDTO request) {
        log.info(Constants.LOG_KEY_MESSAGE + Constants.LOG_KEY_METHOD , Constants.LOG_MSG_START_AUTHENTICATE_USER, Constants.LOG_METHOD_AUTHENTICATE);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new JwtDTO(tokenProvider.generateToken(authentication));
    }
}
