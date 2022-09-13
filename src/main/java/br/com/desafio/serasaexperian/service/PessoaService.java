package br.com.desafio.serasaexperian.service;

import br.com.desafio.serasaexperian.domain.Pessoa;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaDTO;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaGetAllDTO;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaGetByIdDTO;
import br.com.desafio.serasaexperian.domain.enums.Regiao;
import br.com.desafio.serasaexperian.domain.enums.UF;
import br.com.desafio.serasaexperian.repository.PessoaRepository;
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
        var pessoa = mapper.map(pessoaDTO, Pessoa.class);
        pessoa.setRegiao(Regiao.getName(pessoaDTO.getRegiao()));
        return mapper.map(pessoaRepository.save(pessoa), PessoaDTO.class);
    }

    public List<PessoaGetAllDTO> findAll() {
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
        var pessoaOptional = pessoaRepository.findById(id);
        var pessoa = mapper.map(pessoaOptional, PessoaGetByIdDTO.class);

        pessoa.setEstados(getRegion(pessoaOptional.get()));
        pessoa.setScoreDescricao(getScore(pessoaOptional.get()));

        return pessoa;
    }

    private String getScore(Pessoa pessoa) {return scoreService.getDescriptionScore(pessoa.getScore());}

    private Set<UF> getRegion(Pessoa pessoa) {return afinidadeService.findStatesAffinityByRegion(pessoa.getRegiao());}
}
