package com.lgtech.gestao_escolar.controller;

import com.lgtech.gestao_escolar.dto.EscolaDTO.EscolaRequestDTO;
import com.lgtech.gestao_escolar.dto.EscolaDTO.EscolaResponseDTO;
import com.lgtech.gestao_escolar.entity.Escola;
import com.lgtech.gestao_escolar.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @PostMapping
    public ResponseEntity<EscolaResponseDTO> inserir(@RequestBody EscolaRequestDTO data) {
        Escola escola = escolaService.inserir(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EscolaResponseDTO(escola));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EscolaResponseDTO> alterar(@PathVariable Integer id, @RequestBody EscolaRequestDTO data) {
        Escola escola = escolaService.alterar(id, data);;
        return ResponseEntity.ok(new EscolaResponseDTO(escola));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        escolaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EscolaResponseDTO>> listar() {
        List<EscolaResponseDTO> escolaList = escolaService.listar().stream().map(EscolaResponseDTO::new).toList();
        return ResponseEntity.ok(escolaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscolaResponseDTO> consultar(@PathVariable Integer id) {
        EscolaResponseDTO escola = new EscolaResponseDTO(escolaService.consultar(id));
        return ResponseEntity.ok(escola);
    }

}
