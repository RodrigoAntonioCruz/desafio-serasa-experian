package br.com.desafio.serasaexperian.http;

import br.com.desafio.serasaexperian.configuration.OpenFeignConfiguration;
import br.com.desafio.serasaexperian.domain.dto.score.ScoreDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "score", url = "http://localhost:8887/api/v1/score", configuration = OpenFeignConfiguration.class)
public interface ScoreClient {
    @PostMapping
    ScoreDTO insertScore(@RequestBody ScoreDTO scoreDTO);

}
