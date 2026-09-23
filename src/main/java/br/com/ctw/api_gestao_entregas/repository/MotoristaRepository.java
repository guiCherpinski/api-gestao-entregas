package br.com.ctw.api_gestao_entregas.repository;

import br.com.ctw.api_gestao_entregas.entity.MotoristaEntity;
import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MotoristaRepository extends JpaRepository<MotoristaEntity, Long> {

    @Query
    Optional<MotoristaEntity> findByNome(String nome);
}
