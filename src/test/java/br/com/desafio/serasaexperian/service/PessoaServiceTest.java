package br.com.desafio.serasaexperian.service;

import br.com.desafio.serasaexperian.domain.Pessoa;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaGetByIdDTO;
import br.com.desafio.serasaexperian.domain.enums.Regiao;
import br.com.desafio.serasaexperian.factory.ScenarioFactory;
import br.com.desafio.serasaexperian.util.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest extends ScenarioFactory {
    @InjectMocks
    private PessoaService pessoaService;

    @Before
    public void setup() {

        SCORE_DTO = getScore();

        AFINIDADE_DTO = getAfinidade();

        PESSOA = getPessoa();

        PESSOA_DTO = getPessoaDTO();

        PESSOA_GET_ALL_DTO = getPessoaGetAllDTO();

        PESSOA_GET_BY_ID_DTO = getPessoaGetByIdDTO();

        when(pessoaRepository.save(PESSOA)).thenReturn(PESSOA);

        when(mapper.map(PESSOA_DTO, Pessoa.class)).thenReturn(PESSOA);

        when(pessoaRepository.findAll()).thenReturn(List.of(PESSOA));

        when(pessoaRepository.findById(PESSOA.getId())).thenReturn(Optional.ofNullable(PESSOA));

        when(mapper.map(Optional.ofNullable(PESSOA), PessoaGetByIdDTO.class)).thenReturn(PESSOA_GET_BY_ID_DTO);

        when(ReflectionTestUtils.invokeMethod(pessoaService, "getScore", PESSOA)).thenReturn(SCORE_DTO.getScoreDescricao());

        when(ReflectionTestUtils.invokeMethod(pessoaService, "getRegion", PESSOA)).thenReturn(AFINIDADE_DTO.getEstados());

        when(pessoaRepository.save(PESSOA)).thenThrow(new RuntimeException(Constants.ERROR_VALIDATION));
    }

    @Test
    @DisplayName("Testa o cadastro de uma pessoa com sucesso")
    public void when_registering_person_return_success(){

        var pessoa = pessoaService.create(PESSOA_DTO);

        verify(pessoaRepository, times(1)).save(PESSOA);

        assertEquals(pessoa.getNome(), PESSOA_DTO.getNome());
        assertEquals(pessoa.getTelefone(), PESSOA_DTO.getTelefone());
        assertEquals(pessoa.getIdade(), PESSOA_DTO.getIdade());
        assertEquals(pessoa.getCidade(), PESSOA_DTO.getCidade());
        assertEquals(pessoa.getScore(), PESSOA_DTO.getScore());
        assertEquals(pessoa.getRegiao(), String.valueOf(Regiao.getName(PESSOA_DTO.getRegiao())));
    }

    @Test
    @DisplayName("Testa a busca de todas as pessoa com sucesso")
    public void when_findAll_people_return_success(){

        var pessoa = pessoaService.findAll();

        verify(pessoaRepository, times(1)).findAll();

        pessoa.forEach(p->{
            assertEquals(p.getNome(), PESSOA_DTO.getNome());
            assertEquals(p.getCidade(), PESSOA_DTO.getCidade());
            assertEquals(p.getEstado(), PESSOA_DTO.getEstado());
            assertEquals(p.getScoreDescricao(), SCORE_DTO.getScoreDescricao());
            assertEquals(p.getEstados(), AFINIDADE_DTO.getEstados());
        });
    }

    @Test
    @DisplayName("Testa a busca de uma pessoa por id com sucesso")
    public void when_findById_people_return_success(){

        var pessoa = pessoaService.findById(PESSOA.getId());

        verify(pessoaRepository, times(1)).findById(PESSOA.getId());

        assertEquals(pessoa.getNome(), PESSOA_DTO.getNome());
        assertEquals(pessoa.getTelefone(), PESSOA_DTO.getTelefone());
        assertEquals(pessoa.getIdade(), PESSOA_DTO.getIdade());
        assertEquals(pessoa.getScoreDescricao(), SCORE_DTO.getScoreDescricao());
        assertEquals(pessoa.getEstados(), AFINIDADE_DTO.getEstados());

    }

    @Test
    @DisplayName("Testa o retorno de uma exceção ao cadastrar uma pessoa com campos nulos")
    public void when_registering_empty_or_null_person_field_return_exception() {
        PESSOA_DTO.setNome(null);
        PESSOA_DTO.setScore(null);

        var exception = Assertions.assertThrows(RuntimeException.class,() -> {
            pessoaService.create(PESSOA_DTO);
        });

        verify(pessoaRepository, times(1)).save(PESSOA);

        assertEquals(Constants.ERROR_VALIDATION, exception.getMessage());
    }
}
