package br.com.ctw.api_gestao_entregas.controller;

import br.com.ctw.api_gestao_entregas.dto.DadosAutenticacaoDTO;
import br.com.ctw.api_gestao_entregas.dto.DadosTokenJWT;
import br.com.ctw.api_gestao_entregas.entity.UsuarioEntity;
import br.com.ctw.api_gestao_entregas.service.TokenService;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService service;

    public AutenticacaoController(AuthenticationManager manager, TokenService service){
        this.manager = manager;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados){
        var autenticacaoToken = new UsernamePasswordAuthenticationToken(dados.username(), dados.password());
        var autenticacao =  manager.authenticate(autenticacaoToken);

        String tokenJWT = service.gerarToken((UsuarioEntity) autenticacao.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
