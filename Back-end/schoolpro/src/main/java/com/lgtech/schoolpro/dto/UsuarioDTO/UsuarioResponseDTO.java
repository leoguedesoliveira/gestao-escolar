package com.lgtech.schoolpro.dto.UsuarioDTO;

import com.lgtech.schoolpro.entity.Escola;
import com.lgtech.schoolpro.entity.Usuario;

public record UsuarioResponseDTO(Integer id, String nome, String login, String senha, String email, Escola escola, Integer unidade) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha(), usuario.getEmail(), usuario.getEscola(), usuario.getUnidade());
    }
}
