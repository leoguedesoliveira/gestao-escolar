package com.lgtech.gestao_escolar.controller;

import com.lgtech.gestao_escolar.dto.UsuarioDTO.UsuarioRequestDTO;
import com.lgtech.gestao_escolar.dto.UsuarioDTO.UsuarioResponseDTO;
import com.lgtech.gestao_escolar.entity.Usuario;
import com.lgtech.gestao_escolar.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> inserir(@RequestBody UsuarioRequestDTO data) {
        Usuario usuario = usuarioService.inserir(data);
        return ResponseEntity.status(HttpStatus.CREATED).body((new UsuarioResponseDTO(usuario)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> alterar(@PathVariable Integer id, @RequestBody UsuarioRequestDTO data) {
        Usuario usuario = usuarioService.alterar(id, data);
        return ResponseEntity.ok((new UsuarioResponseDTO(usuario)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        String mensagem = usuarioService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mensagem);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        List<UsuarioResponseDTO> usuarioList = usuarioService.listar().stream().map(UsuarioResponseDTO::new).toList();
        return ResponseEntity.ok(usuarioList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> consultar(@PathVariable Integer id) {
        UsuarioResponseDTO usuario = new UsuarioResponseDTO(usuarioService.consultar(id));
        return ResponseEntity.ok(usuario);
    }
}
