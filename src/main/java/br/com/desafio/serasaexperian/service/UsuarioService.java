package br.com.desafio.serasaexperian.service;

import br.com.desafio.serasaexperian.domain.Perfil;
import br.com.desafio.serasaexperian.domain.Usuario;
import br.com.desafio.serasaexperian.domain.dto.usuario.request.LoginRequest;
import br.com.desafio.serasaexperian.domain.dto.usuario.request.SignupRequest;
import br.com.desafio.serasaexperian.domain.dto.usuario.response.JwtResponse;
import br.com.desafio.serasaexperian.domain.dto.usuario.response.UserResponse;
import br.com.desafio.serasaexperian.domain.enums.EPerfil;
import br.com.desafio.serasaexperian.repository.UsuarioRepository;
import br.com.desafio.serasaexperian.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final ModelMapper mapper;
    private final PasswordEncoder pwd;
    private JwtTokenProvider tokenProvider;
    private final UsuarioRepository usuarioRepository;
    private AuthenticationManager authenticationManager;

    public JwtResponse authenticate(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new JwtResponse(tokenProvider.generateToken(authentication));
    }

    public UserResponse register(SignupRequest request) {

        Usuario usuario = mapper.map(request, Usuario.class);

        usuario.setSenha(pwd.encode(request.getSenha()));

        usuario.setPerfis(Set.of(Perfil.builder().nome(String.valueOf(EPerfil.ROLE_USER)).build()));

        return mapper.map(usuarioRepository.save(usuario), UserResponse.class);
    }
}
