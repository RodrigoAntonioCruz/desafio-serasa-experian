package br.com.desafio.serasaexperian.domain;

import br.com.desafio.serasaexperian.domain.enums.Regiao;
import br.com.desafio.serasaexperian.domain.enums.UF;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PESSOA")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = -1201170870917567259L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    private Date dataInclusao;

    private String nome;

    private String telefone;

    private Integer idade;

    private String cidade;

    @Enumerated
    private UF estado;

    private Integer score;

    @Enumerated
    private Regiao regiao;
}
