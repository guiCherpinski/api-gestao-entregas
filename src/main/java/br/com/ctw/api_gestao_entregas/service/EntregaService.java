package br.com.ctw.api_gestao_entregas.service;

import br.com.ctw.api_gestao_entregas.dto.EntregaResponseDTO;
import br.com.ctw.api_gestao_entregas.entity.EntregaEntity;
import br.com.ctw.api_gestao_entregas.mapper.EntregaMapper;
import br.com.ctw.api_gestao_entregas.repository.EntregaRepository;
import br.com.ctw.api_gestao_entregas.repository.MotoristaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EntregaService {

    private final EntregaRepository repository;
    private final MotoristaRepository motoristaRepository;
    private final EntregaMapper mapper;

    public EntregaService(EntregaRepository repository, MotoristaRepository motoristaRepository, EntregaMapper mapper){
        this.repository = repository;
        this.motoristaRepository = motoristaRepository;
        this.mapper = mapper;
    }

    @Transactional
    public EntregaResponseDTO buscarEntrega(Long id){
        EntregaEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("erro - entrega não encontrada"));
        EntregaResponseDTO response = mapper.toResponse(entity);
        return response;
    }

    @Transactional
    public void deletarEntrega(Long id){
        repository.deleteById(id);
    }
}
