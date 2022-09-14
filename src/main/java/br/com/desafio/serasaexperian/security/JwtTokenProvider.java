package br.com.desafio.serasaexperian.security;

import br.com.desafio.serasaexperian.configuration.EnvironmentConfiguration;
import br.com.desafio.serasaexperian.util.Constants;
import io.jsonwebtoken.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@AllArgsConstructor
public class JwtTokenProvider {
    private final EnvironmentConfiguration env;

    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + env.getJwtTimeExpiration());

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, env.getJwtSecret())
                .compact();
    }

    public String getUsernameFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(env.getJwtSecret())
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(env.getJwtSecret()).parseClaimsJws(token);
            return true;
        } catch (SecurityException e) {
            log.error("Assinatura JWT inválida: {}", e.getMessage());
            throw new SecurityException(Constants.MESSAGE_INVALID_JWT_SIGNATURE);
        } catch (MalformedJwtException e) {
            log.error("Token JWT inválido: {}", e.getMessage());
            throw new SecurityException(Constants.MESSAGE_INVALID_JWT_TOKEN);
        } catch (ExpiredJwtException e) {
            log.error("Token JWT expirou: {}", e.getMessage());
            throw new SecurityException(Constants.MESSAGE_EXPIRED_JWT_TOKEN);
        } catch (UnsupportedJwtException e) {
            log.error("Token JWT é incompatível: {}", e.getMessage());
            throw new SecurityException(Constants.MESSAGE_UNSUPPORTED_JWT_TOKEN);
        } catch (IllegalArgumentException e) {
            log.error("String JWT está vazia: {}", e.getMessage());
            throw new SecurityException(Constants.MESSAGE_EMPTY_JWT_TOKEN);
        }
    }
}
