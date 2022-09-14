package br.com.desafio.serasaexperian.http;

import br.com.desafio.serasaexperian.domain.dto.usuario.SignupDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "usuario", url = "http://localhost:8887/api/v1/usuario/registrar")
public interface UsuarioClient {
    @PostMapping
    SignupDTO insertUsuario(@RequestBody SignupDTO signupDTO);
}
