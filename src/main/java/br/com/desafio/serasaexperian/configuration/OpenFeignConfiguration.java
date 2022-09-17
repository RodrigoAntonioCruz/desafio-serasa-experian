package br.com.desafio.serasaexperian.configuration;

import br.com.desafio.serasaexperian.domain.dto.usuario.LoginDTO;
import br.com.desafio.serasaexperian.security.AuthenticateProvider;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;


@AllArgsConstructor
public class OpenFeignConfiguration implements RequestInterceptor {
    private final EnvironmentConfiguration env;
    private final AuthenticateProvider authenticateProvider;
    @Override
    public void apply(RequestTemplate template) {

        final String authorization = HttpHeaders.AUTHORIZATION;

        var login = LoginDTO.builder().email(env.getApiUser()).senha(env.getApiSecret()).build();

        String token = authenticateProvider.getToken(login).getToken();

        template.header(authorization, token);
    }
}
