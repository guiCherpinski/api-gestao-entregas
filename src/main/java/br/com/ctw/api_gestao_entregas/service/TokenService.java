package br.com.ctw.api_gestao_entregas.service;

import br.com.ctw.api_gestao_entregas.entity.UsuarioEntity;
import com.auth0.jwt.JWT;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret: }")
    private String secret;

    public String gerarToken(UsuarioEntity usuarioEntity){
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("api de gestão de entregas")
                    .withSubject(usuarioEntity.getUsername())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        }catch (JWTCreationException e){
            throw new RuntimeException("erro ao gerar o token JWT ",e);
        }
    }

    public String getSubject(String tokenJwt){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("api de gestão de entregas")
                    .build()
                    .verify(tokenJwt)
                    .getSubject();
        }catch (JWTVerificationException e){
            return null;
        }
    }

    private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
