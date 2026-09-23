package br.com.ctw.api_gestao_entregas.controller;

import br.com.ctw.api_gestao_entregas.dto.MotoristaCreateDto;
import br.com.ctw.api_gestao_entregas.dto.MotoristaResponseDTO;
import br.com.ctw.api_gestao_entregas.service.MotoristaService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api/motoristas")
public class MotoristaController {

    private final MotoristaService service;

    public MotoristaController(MotoristaService service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<MotoristaResponseDTO> cadastrarMotorista(MotoristaCreateDto create){
        return ResponseEntity.ok(service.cadastrarMotorista(create));
    }

    @GetMapping()
    public ResponseEntity<List<MotoristaResponseDTO>> listarMotoristas(){
        return ResponseEntity.ok(service.listarMotoristas());
    }
}
