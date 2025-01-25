package com.lgtech.gestao_escolar.dto.UsuarioDTO;

import com.lgtech.gestao_escolar.entity.Escola;
import com.lgtech.gestao_escolar.entity.Unidade;
import com.lgtech.gestao_escolar.entity.Usuario;

public record UsuarioResponseDTO(Integer id, String nome, String email, String senha, Escola escola, Integer unidade) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getEscola(), usuario.getUnidade());
    }
}
