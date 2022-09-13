package br.com.desafio.serasaexperian.domain;

import br.com.desafio.serasaexperian.domain.enums.Regiao;
import br.com.desafio.serasaexperian.domain.enums.UF;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_AFINIDADE")
public class Afinidade implements Serializable {
        private static final long serialVersionUID = 6006254074920559284L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated
        private Regiao regiao;

        @ElementCollection(targetClass = UF.class)
        private Set<UF> estados = new HashSet<>();
}
