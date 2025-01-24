package com.lgtech.schoolpro.controllers;

import com.lgtech.schoolpro.dto.UsuarioDTO.UsuarioRequestDTO;
import com.lgtech.schoolpro.dto.UsuarioDTO.UsuarioResponseDTO;
import com.lgtech.schoolpro.entity.Usuario;
import com.lgtech.schoolpro.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    public void createUsuario(@RequestBody UsuarioRequestDTO data) {
        Usuario usuario = new Usuario(data);
        service.createUser(usuario);
    }

    @GetMapping
    public List<UsuarioResponseDTO> getAll() {

        List<UsuarioResponseDTO> listaUsuario = service.getAll().stream().map(UsuarioResponseDTO::new).toList();
        return listaUsuario;
    }
}
