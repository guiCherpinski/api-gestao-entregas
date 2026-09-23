package br.com.ctw.api_gestao_entregas.controller;

import br.com.ctw.api_gestao_entregas.dto.MotoristaCreateDto;
import br.com.ctw.api_gestao_entregas.dto.MotoristaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/motoristas")
public class MotoristaController {

    @PostMapping()
    public ResponseEntity<MotoristaResponseDTO> cadastrarMotorista(MotoristaCreateDto create){

    }

    @GetMapping()
    public ResponseEntity<List<MotoristaResponseDTO>> listarMotoristas(){

    }
}
