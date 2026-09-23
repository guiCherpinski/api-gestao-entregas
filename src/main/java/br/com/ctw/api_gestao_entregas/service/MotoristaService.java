package br.com.ctw.api_gestao_entregas.service;

import br.com.ctw.api_gestao_entregas.dto.MotoristaCreateDto;
import br.com.ctw.api_gestao_entregas.dto.MotoristaResponseDTO;
import br.com.ctw.api_gestao_entregas.entity.MotoristaEntity;
import br.com.ctw.api_gestao_entregas.mapper.MotoristaMapper;
import br.com.ctw.api_gestao_entregas.repository.MotoristaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MotoristaService {

    private final MotoristaRepository repository;
    private final MotoristaMapper mapper;

    public MotoristaService(MotoristaRepository repository, MotoristaMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public MotoristaResponseDTO cadastrarMotorista(MotoristaCreateDto create){
        MotoristaEntity entity = mapper.toEntity(create);
        repository.save(entity);
        MotoristaResponseDTO response = mapper.toResponse(entity);
        return response;
    }

    @Transactional
    public List<MotoristaResponseDTO> listarMotoristas(){
        List<MotoristaEntity> motoristas = repository.findAll();
        List<MotoristaResponseDTO> responses = mapper.toResponseList(motoristas);
        return responses;
    }
}
