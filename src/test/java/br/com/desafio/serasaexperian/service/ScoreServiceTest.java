package br.com.desafio.serasaexperian.service;

import br.com.desafio.serasaexperian.domain.Score;
import br.com.desafio.serasaexperian.factory.ScenarioFactory;
import br.com.desafio.serasaexperian.repository.ScoreRepository;
import br.com.desafio.serasaexperian.util.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ScoreServiceTest  extends ScenarioFactory {
    @InjectMocks
    private ScoreService scoreService;

    @Mock
    protected ScoreRepository scoreRepository;

    @Before
    public void setup() {
        SCORE_DTO = getScoreDTO();

        SCORE = getScore();

        when(scoreRepository.save(SCORE)).thenReturn(SCORE);

        when(mapper.map(SCORE_DTO, Score.class)).thenReturn(SCORE);

        when(scoreRepository.findDescriptionByScore(1)).thenReturn(Optional.of(SCORE));
    }

    @Test
    @DisplayName("Testa o cadastro de um score com sucesso")
    public void when_register_score_return_success(){
        var score = scoreService.create(SCORE_DTO);

        verify(scoreRepository, times(1)).save(SCORE);

        assertEquals(score.getScoreDescricao(), SCORE_DTO.getScoreDescricao());
        assertEquals(score.getValorInicial(), SCORE_DTO.getValorInicial());
        assertEquals(score.getValorFinal(), SCORE_DTO.getValorFinal());
    }

    @Test
    @DisplayName("Testa a busca da descrição por score com sucesso")
    public void when_getDescriptionScore_return_success(){

        var score = scoreService.findDescriptionByScore(1);

        verify(scoreRepository, times(1)).findDescriptionByScore(1);

        assertEquals(score, SCORE_DTO.getScoreDescricao());
    }

    @Test
    @DisplayName("Testa o retorno de uma exceção ao cadastrar um score com campos nulos")
    public void when_register_empty_or_null_affinity_field_return_exception() {
        SCORE_DTO.setScoreDescricao(null);
        SCORE_DTO.setValorInicial(null);
        SCORE_DTO.setValorFinal(null);

        when(scoreRepository.save(SCORE)).thenThrow(EXCEPTION);

        var exception = Assertions.assertThrows(RuntimeException.class,() -> {
            scoreService.create(SCORE_DTO);
        });

        verify(scoreRepository, times(1)).save(SCORE);

        assertEquals(Constants.MESSAGE_INVALID_DATA, exception.getMessage());
    }
}

