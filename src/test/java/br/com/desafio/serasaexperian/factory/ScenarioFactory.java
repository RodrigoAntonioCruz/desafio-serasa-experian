package br.com.desafio.serasaexperian.factory;

import br.com.desafio.serasaexperian.domain.Afinidade;
import br.com.desafio.serasaexperian.domain.Pessoa;
import br.com.desafio.serasaexperian.domain.Score;
import br.com.desafio.serasaexperian.domain.dto.afinidade.AfinidadeDTO;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaDTO;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaGetAllDTO;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaGetByIdDTO;
import br.com.desafio.serasaexperian.domain.dto.score.ScoreDTO;
import br.com.desafio.serasaexperian.domain.enums.Regiao;
import br.com.desafio.serasaexperian.domain.enums.UF;
import br.com.desafio.serasaexperian.util.Constants;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;

import java.util.Set;

public class ScenarioFactory {
    @Spy
    protected ModelMapper mapper;
    protected static PessoaDTO PESSOA_DTO;
    protected static PessoaGetAllDTO PESSOA_GET_ALL_DTO;
    protected static PessoaGetByIdDTO PESSOA_GET_BY_ID_DTO;
    protected static Pessoa PESSOA;
    protected static Score SCORE;
    protected static ScoreDTO SCORE_DTO;
    protected static Afinidade AFINIDADE;
    protected static AfinidadeDTO AFINIDADE_DTO;

    protected RuntimeException EXCEPTION = new RuntimeException(Constants.MESSAGE_INVALID_DATA);
    public ScoreDTO getScoreDTO(){
        return ScoreDTO.builder()
                .scoreDescricao("Inaceitável")
                .valorInicial(201)
                .valorFinal(500)
                .build();
    }

    public AfinidadeDTO getAfinidadeDTO(){
        return AfinidadeDTO.builder()
                .regiao("sudeste")
                .estados(Set.of(UF.RJ, UF.SP, UF.MG, UF.ES))
                .build();
    }

    public Score getScore(){
        return Score.builder()
                .descricao("Inaceitável")
                .valorInicial(201)
                .valorFinal(500)
                .build();
    }

    public Afinidade getAfinidade(){
        return Afinidade.builder()
                .regiao(Regiao.SUDESTE)
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
