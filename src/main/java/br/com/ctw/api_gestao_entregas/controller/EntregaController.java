package br.com.ctw.api_gestao_entregas.controller;

import br.com.ctw.api_gestao_entregas.dto.EntregaResponseDTO;
import br.com.ctw.api_gestao_entregas.service.EntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    private final EntregaService service;

    public EntregaController(EntregaService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaResponseDTO> buscarEntrega(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarEntrega(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEntrega(@PathVariable Long id){
        service.deletarEntrega(id);
        return ResponseEntity.noContent().build();
    }

}
