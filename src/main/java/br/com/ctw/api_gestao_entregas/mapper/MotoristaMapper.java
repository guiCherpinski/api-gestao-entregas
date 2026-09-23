package br.com.ctw.api_gestao_entregas.mapper;

import br.com.ctw.api_gestao_entregas.dto.MotoristaCreateDto;
import br.com.ctw.api_gestao_entregas.dto.MotoristaResponseDTO;
import br.com.ctw.api_gestao_entregas.entity.MotoristaEntity;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class MotoristaMapper {

    public MotoristaEntity toEntity(MotoristaCreateDto create){
        return MotoristaEntity.builder()
                .nome(create.nome())
                .cnh(create.cnh())
                .build();
    }

    public MotoristaResponseDTO toResponse(MotoristaEntity entity){
        return new MotoristaResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getCnh()
        );
    }

    public List<MotoristaResponseDTO> toResponseList (List<MotoristaEntity> entitys){
        return entitys.stream().map(this::toResponse).toList();
    }
}
