package br.com.desafio.serasaexperian.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_SCORE")
public class Score implements Serializable {
        private static final long serialVersionUID = 6837643576584462189L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long id;

        private String descricao;

        private Integer valorInicial;

        private Integer valorFinal;
}
