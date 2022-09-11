package br.com.desafio.serasaexperian.security;

import br.com.desafio.serasaexperian.domain.Perfil;
import br.com.desafio.serasaexperian.domain.Usuario;
import br.com.desafio.serasaexperian.repository.UsuarioRepository;
import br.com.desafio.serasaexperian.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(Constants.FIELD_USER + email + Constants.MESSAGE_NOT_FOUND));

        return new org.springframework.security.core.userdetails.User(usuario.getEmail(),
                usuario.getSenha(), mapRolesToAuthorities(usuario.getPerfis()));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Perfil> perfils){
        return perfils.stream().map(role -> new SimpleGrantedAuthority(role.getNome())).collect(Collectors.toList());
    }
}
