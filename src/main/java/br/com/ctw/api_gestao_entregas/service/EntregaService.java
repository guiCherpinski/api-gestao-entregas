package br.com.ctw.api_gestao_entregas.service;

import br.com.ctw.api_gestao_entregas.dto.EntregaResponseDTO;
import br.com.ctw.api_gestao_entregas.repository.EntregaRepository;
import br.com.ctw.api_gestao_entregas.repository.MotoristaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EntregaService {

    private final EntregaRepository repository;
    private final MotoristaRepository motoristaRepository;

    public EntregaService(EntregaRepository repository, MotoristaRepository motoristaRepository){
        this.repository = repository;
        this.motoristaRepository = motoristaRepository;
    }

    @Transactional
    public EntregaResponseDTO buscarEntrega(Long id){

    }

    @Transactional
    public void deletarEntrega(Long id){

    }
}
