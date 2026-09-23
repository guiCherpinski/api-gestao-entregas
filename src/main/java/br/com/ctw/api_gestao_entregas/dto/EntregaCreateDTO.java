package br.com.ctw.api_gestao_entregas.dto;

public record EntregaCreateDTO(
        String descricao,
        String status,
        Long id
) {
}
