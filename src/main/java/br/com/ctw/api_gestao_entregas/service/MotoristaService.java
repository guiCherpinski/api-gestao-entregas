package br.com.ctw.api_gestao_entregas.service;

import br.com.ctw.api_gestao_entregas.dto.MotoristaCreateDto;
import br.com.ctw.api_gestao_entregas.dto.MotoristaResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MotoristaService {

    @Transactional
    public MotoristaResponseDTO cadastrarMotorista(MotoristaCreateDto create){

    }

    @Transactional
    public List<MotoristaResponseDTO> listarMotoristas(){

    }
}
