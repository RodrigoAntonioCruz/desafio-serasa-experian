package br.com.desafio.serasaexperian.service;

import br.com.desafio.serasaexperian.domain.Afinidade;
import br.com.desafio.serasaexperian.domain.enums.Regiao;
import br.com.desafio.serasaexperian.domain.enums.UF;
import br.com.desafio.serasaexperian.factory.ScenarioFactory;
import br.com.desafio.serasaexperian.repository.AfinidadeRepository;
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
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AfinidadeServiceTest  extends ScenarioFactory {

    @InjectMocks
    private AfinidadeService afinidadeService;

    @Mock
    protected AfinidadeRepository afinidadeRepository;

    @Before
    public void setup() {
        AFINIDADE_DTO = getAfinidadeDTO();

        AFINIDADE = getAfinidade();

        when(afinidadeRepository.save(AFINIDADE)).thenReturn(AFINIDADE);

        when(mapper.map(AFINIDADE_DTO, Afinidade.class)).thenReturn(AFINIDADE);

        when(afinidadeRepository.findByRegiao(Regiao.SUDESTE)).thenReturn(Optional.of(AFINIDADE));
    }

    @Test
    @DisplayName("Testa o cadastro de uma afinidade com sucesso")
    public void when_register_affinity_return_success(){
        var afinidade = afinidadeService.create(AFINIDADE_DTO);

        verify(afinidadeRepository, times(1)).save(AFINIDADE);

        assertEquals(afinidade.getRegiao(), String.valueOf(Regiao.getName(AFINIDADE_DTO.getRegiao())));
        assertEquals(afinidade.getEstados(), AFINIDADE_DTO.getEstados());
    }

    @Test
    @DisplayName("Testa a busca dos estados de afinidade por região com sucesso")
    public void when_findStatesAffinityByRegion_return_success(){

        var estados = afinidadeService.findStatesAffinityByRegion(AFINIDADE.getRegiao());

        verify(afinidadeRepository, times(1)).findByRegiao(Regiao.SUDESTE);

        assertEquals(estados, Set.of(UF.RJ, UF.SP, UF.MG, UF.ES));

    }

    @Test
    @DisplayName("Testa o retorno de uma exceção ao cadastrar uma afinidade com campos nulos")
    public void when_register_empty_or_null_affinity_field_return_exception() {
        AFINIDADE_DTO.setEstados(null);
        AFINIDADE_DTO.setRegiao(null);

        when(afinidadeRepository.save(AFINIDADE)).thenThrow(EXCEPTION);

        var exception = Assertions.assertThrows(RuntimeException.class,() -> {
            afinidadeService.create(AFINIDADE_DTO);
        });

        verify(afinidadeRepository, times(1)).save(AFINIDADE);

        assertEquals(Constants.MESSAGE_INVALID_DATA, exception.getMessage());
    }
}
