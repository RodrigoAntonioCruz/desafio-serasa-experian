package br.com.desafio.serasaexperian.repository;

import br.com.desafio.serasaexperian.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    @Query("FROM Score WHERE :scoreValue >= valorInicial AND :scoreValue <= valorFinal")
    Optional<Score> findScoreBetweenInitialAndFinalValue(Integer scoreValue);
}
