package br.com.desafio.serasaexperian.http;

import br.com.desafio.serasaexperian.domain.dto.usuario.SignupDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "usuario", url = "${uri.api.user}")
public interface UsuarioClient {
    @PostMapping
    void insertUsuario(@RequestBody SignupDTO signupDTO);
}
