package br.com.desafio.serasaexperian.service;

import br.com.desafio.serasaexperian.domain.Pessoa;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaDTO;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaGetAllDTO;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaGetByIdDTO;
import br.com.desafio.serasaexperian.domain.enums.Regiao;
import br.com.desafio.serasaexperian.domain.enums.UF;
import br.com.desafio.serasaexperian.exception.ObjectNoContent;
import br.com.desafio.serasaexperian.repository.PessoaRepository;
import br.com.desafio.serasaexperian.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PessoaService {

    private final ModelMapper mapper;
    private final ScoreService scoreService;
    private final AfinidadeService afinidadeService;
    private final PessoaRepository pessoaRepository;

    public PessoaDTO create(PessoaDTO pessoaDTO) {
        log.info(Constants.LOG_KEY_MESSAGE + Constants.LOG_KEY_CLASS + Constants.LOG_KEY_METHOD + Constants.LOG_KEY_ENTITY,
                Constants.LOG_MSG_START_CREATE_PERSON, Constants.LOG_CLASS_PERSON_SERVICE, Constants.LOG_METHOD_CREATE, pessoaDTO);

        var pessoa = mapper.map(pessoaDTO, Pessoa.class);

        pessoa.setRegiao(Regiao.getName(pessoaDTO.getRegiao()));

        return mapper.map(pessoaRepository.save(pessoa), PessoaDTO.class);
    }

    public List<PessoaGetAllDTO> findAll() {
        log.info(Constants.LOG_KEY_MESSAGE + Constants.LOG_KEY_METHOD, Constants.LOG_MSG_FIND_ALL_PERSON, Constants.LOG_METHOD_FIND_ALL);

        return pessoaRepository.findAll().stream()
                .map(p -> PessoaGetAllDTO.builder()
                        .nome(p.getNome())
                        .cidade(p.getCidade())
                        .estado(p.getEstado())
                        .scoreDescricao(getScore(p))
                        .estados(getRegion(p))
                        .build())
                .collect(Collectors.toList());
    }

    public PessoaGetByIdDTO findById(Long id) {
        log.info(Constants.LOG_KEY_MESSAGE + Constants.LOG_KEY_METHOD, Constants.LOG_MSG_FIND_BY_ID_PERSON + id, Constants.LOG_METHOD_FIND_BY_ID);

        var pessoaOptional = pessoaRepository.findById(id).orElseThrow(ObjectNoContent::new);
        var pessoa = mapper.map(pessoaOptional, PessoaGetByIdDTO.class);

        pessoa.setEstados(getRegion(pessoaOptional));
        pessoa.setScoreDescricao(getScore(pessoaOptional));

        return pessoa;
    }

    private String getScore(Pessoa pessoa) {
        return scoreService.getDescriptionScore(pessoa.getScore());
    }

    private Set<UF> getRegion(Pessoa pessoa) {
        return afinidadeService.findStatesAffinityByRegion(pessoa.getRegiao());
    }
}
