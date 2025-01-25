package com.lgtech.gestao_escolar.dto.UsuarioDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lgtech.gestao_escolar.entity.Escola;
import com.lgtech.gestao_escolar.entity.Unidade;

import java.util.Optional;

public record UsuarioRequestDTO(
        String nome,
        String email,
        String senha,
        @JsonProperty("escola") Integer escola,
        @JsonProperty("unidade") Integer unidade
) { }
