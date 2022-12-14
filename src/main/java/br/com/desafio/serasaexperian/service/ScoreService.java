package br.com.desafio.serasaexperian.service;

import br.com.desafio.serasaexperian.domain.Score;
import br.com.desafio.serasaexperian.domain.dto.score.ScoreDTO;
import br.com.desafio.serasaexperian.repository.ScoreRepository;
import br.com.desafio.serasaexperian.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ModelMapper mapper;

    private final ScoreRepository scoreRepository;

    public ScoreDTO create(ScoreDTO scoreDTO) {
        log.info(Constants.LOG_KEY_MESSAGE + Constants.LOG_KEY_METHOD + Constants.LOG_KEY_ENTITY, Constants.LOG_MSG_START_CREATE_SCORE, Constants.LOG_METHOD_CREATE, scoreDTO);

        var score = mapper.map(scoreDTO, Score.class);
        score.setDescricao(scoreDTO.getScoreDescricao());

        var result = mapper.map(scoreRepository.save(score), ScoreDTO.class);
        result.setScoreDescricao(score.getDescricao());

        return result;
    }

    public String findDescriptionByScore(Integer score) {
        log.info(Constants.LOG_KEY_MESSAGE + Constants.LOG_KEY_METHOD + Constants.LOG_KEY_SCORE, Constants.LOG_MSG_GET_SCORE_DESCRIPTION, Constants.LOG_METHOD_GET_SCORE_DESCRIPTION, score);

        return scoreRepository.findDescriptionByScore(score).map(Score::getDescricao).orElse(Constants.MESSAGE_SCORE_UNDEFINED);
    }
}
