package br.com.desafio.serasaexperian.factory;

import br.com.desafio.serasaexperian.domain.Pessoa;
import br.com.desafio.serasaexperian.domain.dto.afinidade.AfinidadeDTO;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaDTO;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaGetAllDTO;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaGetByIdDTO;
import br.com.desafio.serasaexperian.domain.dto.score.ScoreDTO;
import br.com.desafio.serasaexperian.domain.enums.Regiao;
import br.com.desafio.serasaexperian.domain.enums.UF;
import br.com.desafio.serasaexperian.repository.PessoaRepository;
import br.com.desafio.serasaexperian.service.AfinidadeService;
import br.com.desafio.serasaexperian.service.ScoreService;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;

import java.util.Set;

public class ScenarioFactory {

    @Mock
    private ScoreService scoreService;
    @Mock
    private AfinidadeService afinidadeService;
    @Mock
    protected PessoaRepository pessoaRepository;
    @Spy
    protected ModelMapper mapper;
    protected static PessoaDTO PESSOA_DTO;
    protected static PessoaGetAllDTO PESSOA_GET_ALL_DTO;
    protected static PessoaGetByIdDTO PESSOA_GET_BY_ID_DTO;
    protected static Pessoa PESSOA;
    protected static ScoreDTO SCORE_DTO;
    protected static AfinidadeDTO AFINIDADE_DTO;

    public ScoreDTO getScore(){
        return ScoreDTO.builder()
                .scoreDescricao("Inaceitável")
                .valorInicial(201)
                .valorFinal(500)
                .build();
    }

    public AfinidadeDTO getAfinidade(){
        return AfinidadeDTO.builder()
                .regiao("sul")
                .estados(Set.of(UF.RJ, UF.SP, UF.MG, UF.ES))
                .build();
    }

    public static Pessoa getPessoa() {
        return Pessoa.builder()
                .id(123145L)
                .nome("Rodrigo Antonio Cruz")
                .telefone("51996585552")
                .idade(37)
                .cidade("Porto Alegre")
                .estado(UF.RS)
                .regiao(Regiao.SUL)
                .score(585)
                .build();
    }

    public static PessoaDTO getPessoaDTO() {
        return PessoaDTO.builder()
                .nome("Rodrigo Antonio Cruz")
                .telefone("51996585552")
                .idade(37)
                .cidade("Porto Alegre")
                .estado(UF.RS)
                .regiao("sul")
                .score(585)
                .build();
    }

    public static PessoaGetAllDTO getPessoaGetAllDTO() {
        return PessoaGetAllDTO.builder()
                .nome("Rodrigo Antonio Cruz")
                .cidade("Porto Alegre")
                .estado(UF.RS)
                .scoreDescricao(SCORE_DTO.getScoreDescricao())
                .estados(AFINIDADE_DTO.getEstados())
                .build();
    }

    public static PessoaGetByIdDTO getPessoaGetByIdDTO() {
        return PessoaGetByIdDTO.builder()
                .nome("Rodrigo Antonio Cruz")
                .telefone("51996585552")
                .idade(37)
                .scoreDescricao(SCORE_DTO.getScoreDescricao())
                .estados(AFINIDADE_DTO.getEstados())
                .build();
    }
}
