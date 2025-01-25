package com.lgtech.gestao_escolar.service;

import com.lgtech.gestao_escolar.dto.UsuarioDTO.UsuarioRequestDTO;
import com.lgtech.gestao_escolar.entity.Usuario;
import com.lgtech.gestao_escolar.exceptions.UsuarioEmailExist;
import com.lgtech.gestao_escolar.exceptions.UsuarioNotFound;
import com.lgtech.gestao_escolar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario inserir(UsuarioRequestDTO data) {
        if(usuarioRepository.findByEmail(data.email()).isPresent()) {
            throw new UsuarioEmailExist();
        } else {
            Usuario usuario = new Usuario(data);
            return usuarioRepository.save(usuario);
        }
    }

    public Usuario alterar(Integer id, UsuarioRequestDTO data) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(usuario.isPresent()) {

            Usuario usuarioExistente = usuario.get();
            usuarioExistente.setNome(data.nome());
            usuarioExistente.setEmail(data.email());
            usuarioExistente.setSenha(data.senha());
            usuarioRepository.save(usuarioExistente);

            return usuarioExistente;
        } else {
            throw new UsuarioNotFound();
        }
    }

    public String excluir(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()) {
            Usuario usuarioExistente = usuario.get();
            usuarioRepository.deleteById(usuarioExistente.getId());

            return "Usuário excluído com sucesso";
        } else {
            throw new UsuarioNotFound();
        }
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario consultar(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new UsuarioNotFound();
        }
    }
}
