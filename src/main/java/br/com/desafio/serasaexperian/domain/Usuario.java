package br.com.desafio.serasaexperian.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_USUARIO", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 4873227339830353084L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_perfis",
        joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "perfil_id", referencedColumnName = "id"))
    private Set<Perfil> perfis;
}
