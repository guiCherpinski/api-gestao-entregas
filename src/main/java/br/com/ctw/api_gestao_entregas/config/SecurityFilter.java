package br.com.ctw.api_gestao_entregas.config;

import br.com.ctw.api_gestao_entregas.repository.UsuarioRepository;
import br.com.ctw.api_gestao_entregas.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService service;
    private final UsuarioRepository repository;

    public SecurityFilter(TokenService service, UsuarioRepository repository){
        this.service = service;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenJWT = recuperarToken(request);

        if(tokenJWT != null){
            String subject = service.getSubject(tokenJWT);

            if(subject != null){
                var usuario = repository.findByUsername(subject).orElse(null);

                if (usuario != null){
                    var autenticacao = new UsernamePasswordAuthenticationToken(
                            usuario, null, usuario.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(autenticacao);
                }
            }
        }

        filterChain.doFilter(request,response);
    }

    private String recuperarToken(HttpServletRequest request){
        String autorizacaoHeader = request.getHeader("Authorization");
        if(autorizacaoHeader != null && autorizacaoHeader.startsWith("Bearer ")){
            return autorizacaoHeader.replace("Bearer ","");
        }
        return null;
    }
}
