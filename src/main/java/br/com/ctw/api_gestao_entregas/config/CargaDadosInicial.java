package br.com.ctw.api_gestao_entregas.config;


import br.com.ctw.api_gestao_entregas.entity.UsuarioEntity;
import br.com.ctw.api_gestao_entregas.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.*;

import java.math.BigDecimal;
import java.util.*;

/** Carga inicial de dados para popular o banco durante a inicialização da aplicação */

@Configuration
public class CargaDadosInicial implements CommandLineRunner {
    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CargaDadosInicial(UsuarioRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String ... args) throws Exception{
        if (userRepository.count() == 0) {
            List<UsuarioEntity> usuariosIniciais = List.of(
                    UsuarioEntity.builder()
                            .username("Eduardo supremo Geffert")
                            .password(passwordEncoder.encode("12345678"))
                            .role("ADMIN")
                            .build(),

                    UsuarioEntity.builder()
                            .username("cherpinski")
                            .password(passwordEncoder.encode("23456789"))
                            .role("USER")
                            .build()
            );
            userRepository.saveAll(usuariosIniciais);
        }
    }
}