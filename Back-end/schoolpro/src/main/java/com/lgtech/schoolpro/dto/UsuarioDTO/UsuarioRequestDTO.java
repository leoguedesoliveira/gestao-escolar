package com.lgtech.schoolpro.dto.UsuarioDTO;

import com.lgtech.schoolpro.entity.Escola;

public record UsuarioRequestDTO(String nome, String login, String senha, String email, Escola escola, Integer unidade) {
}
