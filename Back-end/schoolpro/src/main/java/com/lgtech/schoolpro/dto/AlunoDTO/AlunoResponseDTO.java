package com.lgtech.schoolpro.dto.AlunoDTO;

import com.lgtech.schoolpro.entity.Aluno;
import com.lgtech.schoolpro.entity.Classe;
import com.lgtech.schoolpro.entity.Endereco;
import com.lgtech.schoolpro.entity.Escola;

import java.util.Date;

public record AlunoResponseDTO(
        Integer id,
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
    public AlunoResponseDTO(Aluno aluno) {
        this(
                aluno.getId(),
                aluno.getNome(),
                aluno.getDataNacimento(),
                aluno.getEndereco(),
                aluno.getNomeMae(),
                aluno.getNomePai(),
                aluno.getRa(),
                aluno.getClasse(),
                aluno.getMatriculado(),
                aluno.getDataMatricula(),
                aluno.getDataRematricula(),
                aluno.getTelefone1(),
                aluno.getTelefone2(),
                aluno.getTelefone3(),
                aluno.getEscola(),
                aluno.getUnidade()
        );
    }
}
