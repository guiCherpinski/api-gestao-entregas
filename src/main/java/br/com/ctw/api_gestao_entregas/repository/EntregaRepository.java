package br.com.ctw.api_gestao_entregas.repository;

import br.com.ctw.api_gestao_entregas.entity.EntregaEntity;
import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EntregaRepository extends JpaRepository<EntregaEntity, Long> {

    @Query
    Optional<EntregaEntity> findByDescricao(String descricao);
}
