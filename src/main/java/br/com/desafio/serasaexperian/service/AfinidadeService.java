package br.com.desafio.serasaexperian.service;

import br.com.desafio.serasaexperian.domain.Afinidade;
import br.com.desafio.serasaexperian.domain.dto.afinidade.AfinidadeDTO;
import br.com.desafio.serasaexperian.domain.enums.Regiao;
import br.com.desafio.serasaexperian.domain.enums.UF;
import br.com.desafio.serasaexperian.repository.AfinidadeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class AfinidadeService {

    private final ModelMapper mapper;
    private final AfinidadeRepository afinidadeRepository;
    public AfinidadeDTO create(AfinidadeDTO afinidadeDTO) {
        var afinidade = mapper.map(afinidadeDTO, Afinidade.class);
        afinidade.setRegiao(Regiao.getName(afinidadeDTO.getRegiao()));
        return mapper.map(afinidadeRepository.save(afinidade), AfinidadeDTO.class);
    }

    @Transactional
    public Set<UF> findStatesAffinityByRegion(Regiao regiao) {
        Optional<Afinidade> afinidade = Optional.of(afinidadeRepository.findAffinityByRegion(regiao)
                .orElseThrow());
        return afinidade.get().getEstados();
    }
}
