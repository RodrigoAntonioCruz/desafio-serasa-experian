package br.com.desafio.serasaexperian.repository;

import br.com.desafio.serasaexperian.domain.Afinidade;
import br.com.desafio.serasaexperian.domain.enums.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AfinidadeRepository extends JpaRepository<Afinidade, Long> {
    Optional<Afinidade> findByRegiao(Regiao regiao);

}