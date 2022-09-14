package br.com.desafio.serasaexperian.configuration;

import br.com.desafio.serasaexperian.domain.dto.usuario.JwtDTO;
import br.com.desafio.serasaexperian.security.JwtTokenProvider;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
@AllArgsConstructor
public class OpenFeignConfiguration implements RequestInterceptor {
    private JwtTokenProvider tokenProvider;
    private AuthenticationManager authenticationManager;

    @Override
    public void apply(RequestTemplate template) {
        final String authorization = HttpHeaders.AUTHORIZATION;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken("api@msn.com", "123Aa$Aa"));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = new JwtDTO(tokenProvider.generateToken(authentication)).getToken();

        template.header(authorization, token);

    }
}
