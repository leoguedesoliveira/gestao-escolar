package com.lgtech.schoolpro.services;

import com.lgtech.schoolpro.entity.Usuario;
import com.lgtech.schoolpro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public ResponseEntity<String> createUser(Usuario usuario) {
        repository.save(usuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

    public List<Usuario> getAll() {
        List<Usuario> listaUsuario = repository.findAll();
        return listaUsuario;
    }
}
