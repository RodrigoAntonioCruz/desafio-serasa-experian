package br.com.desafio.serasaexperian.repository;

import br.com.desafio.serasaexperian.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    Optional<Score> findAllByValorFinalGreaterThanEqualAndValorInicialLessThanEqual(Integer valorInicial, Integer valorFinal);
    default Optional<Score> findDescriptionByScore(Integer scoreValue){
        return findAllByValorFinalGreaterThanEqualAndValorInicialLessThanEqual(scoreValue, scoreValue);
    }
}
