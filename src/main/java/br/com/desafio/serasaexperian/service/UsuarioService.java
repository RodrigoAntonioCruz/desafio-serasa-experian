package br.com.desafio.serasaexperian.service;

import br.com.desafio.serasaexperian.domain.Usuario;
import br.com.desafio.serasaexperian.domain.dto.usuario.LoginDTO;
import br.com.desafio.serasaexperian.domain.dto.usuario.SignupDTO;
import br.com.desafio.serasaexperian.domain.dto.usuario.JwtDTO;
import br.com.desafio.serasaexperian.domain.dto.usuario.UserDTO;
import br.com.desafio.serasaexperian.domain.enums.Perfil;
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

    public JwtDTO authenticate(LoginDTO request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new JwtDTO(tokenProvider.generateToken(authentication));
    }

    public UserDTO register(SignupDTO request) {

        Usuario usuario = mapper.map(request, Usuario.class);
        usuario.setSenha(pwd.encode(request.getSenha()));

        usuario.setPerfis(Set.of(br.com.desafio.serasaexperian.domain.Perfil.builder().nome(String.valueOf(Perfil.ROLE_USER)).build()));
        return mapper.map(usuarioRepository.save(usuario), UserDTO.class);
    }
}
