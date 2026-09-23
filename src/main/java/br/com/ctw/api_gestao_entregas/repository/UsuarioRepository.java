package br.com.ctw.api_gestao_entregas.repository;

import br.com.ctw.api_gestao_entregas.entity.UsuarioEntity;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query
    Optional<UsuarioEntity> findByUsername(String username);
}
