package com.lgtech.schoolpro.dto.AlunoDTO;

import com.lgtech.schoolpro.entity.Classe;
import com.lgtech.schoolpro.entity.Endereco;
import com.lgtech.schoolpro.entity.Escola;

import java.util.Date;

public record AlunoRequestDTO(
        String nome,
        Date dataNascimento,
        Endereco endereco,
        String nomeMae,
        String nomePai,
        String ra,
        Classe classe,
        String matriculado,
        Date dataMatricula,
        Date dataRematricula,
        String telefone1,
        String telefone2,
        String telefone3,
        Escola escola,
        Integer unidade
) {
}
