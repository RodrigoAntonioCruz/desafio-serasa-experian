package br.com.desafio.serasaexperian;

import br.com.desafio.serasaexperian.domain.dto.score.ScoreDTO;
import br.com.desafio.serasaexperian.domain.dto.usuario.SignupDTO;
import br.com.desafio.serasaexperian.http.ScoreClient;
import br.com.desafio.serasaexperian.http.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class SerasaExperianApplication implements CommandLineRunner {

	@Autowired
	private ScoreClient scoreClient;

	@Autowired
	private UsuarioClient usuarioClient;

	public static void main(String[] args) {
		SpringApplication.run(SerasaExperianApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var user = SignupDTO.builder().nome("Api User").email("api@msn.com").senha("123Aa$Aa").build();
        usuarioClient.insertUsuario(user);

		var scores = List.of(ScoreDTO.builder().scoreDescricao("Insuficiente").valorInicial(0).valorFinal(200).build(),
				ScoreDTO.builder().scoreDescricao("Inaceitável").valorInicial(201).valorFinal(500).build(),
				ScoreDTO.builder().scoreDescricao("Aceitável").valorInicial(501).valorFinal(700).build(),
				ScoreDTO.builder().scoreDescricao("Recomendável").valorInicial(701).valorFinal(1000).build());

		scores.forEach(score->{
			scoreClient.insertScore(score);
		});
	}
}
