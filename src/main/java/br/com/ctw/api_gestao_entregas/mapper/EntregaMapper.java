package br.com.ctw.api_gestao_entregas.mapper;

import br.com.ctw.api_gestao_entregas.dto.EntregaCreateDTO;
import br.com.ctw.api_gestao_entregas.dto.EntregaResponseDTO;
import br.com.ctw.api_gestao_entregas.entity.EntregaEntity;
import br.com.ctw.api_gestao_entregas.entity.MotoristaEntity;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class EntregaMapper {

    public EntregaEntity toEntity(EntregaCreateDTO createDTO, MotoristaEntity entity){
        return EntregaEntity.builder()
                .descricao(createDTO.descricao())
                .status(createDTO.status())
                .motorista(entity)
                .build();
    }

    public EntregaResponseDTO toResponse(EntregaEntity entity){
        return new EntregaResponseDTO(
                entity.getId(),
                entity.getDescricao(),
                entity.getStatus(),
                entity.getMotorista()
        );
    }

    public List<EntregaResponseDTO> toResponseList(List<EntregaEntity> entiys){
        return entiys.stream().map(this::toResponse).toList();
    }
}
