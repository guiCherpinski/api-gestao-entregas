package br.com.ctw.api_gestao_entregas.dto;

import br.com.ctw.api_gestao_entregas.entity.MotoristaEntity;

public record EntregaResponseDTO(
        Long id,
        String descricao,
        String status,
        MotoristaEntity motorista
) {
}
