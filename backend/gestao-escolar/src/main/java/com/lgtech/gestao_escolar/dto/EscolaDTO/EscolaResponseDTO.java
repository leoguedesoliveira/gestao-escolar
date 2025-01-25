package com.lgtech.gestao_escolar.dto.EscolaDTO;

import com.lgtech.gestao_escolar.entity.Escola;

public record EscolaResponseDTO(Integer id, String nome) {

    public EscolaResponseDTO(Escola escola) {
        this(escola.getId(), escola.getNome());
    }

}
