package br.com.ctw.api_gestao_entregas.controller;

import br.com.ctw.api_gestao_entregas.dto.EntregaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    @GetMapping("/{id}")
    public ResponseEntity<EntregaResponseDTO> buscarEntrega(@PathVariable Long id){

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEntrega(@PathVariable Long id){

    }

}
