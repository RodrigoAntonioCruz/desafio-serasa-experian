package br.com.desafio.serasaexperian.security;

import br.com.desafio.serasaexperian.domain.dto.usuario.JwtDTO;
import br.com.desafio.serasaexperian.domain.dto.usuario.LoginDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthenticateProvider {
    private final JwtTokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;

    public JwtDTO getToken(LoginDTO request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new JwtDTO(tokenProvider.generateToken(authentication));
    }
}
