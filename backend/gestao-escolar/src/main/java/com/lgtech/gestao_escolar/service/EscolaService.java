package com.lgtech.gestao_escolar.service;


import com.lgtech.gestao_escolar.entity.Escola;
import com.lgtech.gestao_escolar.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    public Escola inserir(Escola escola) {
        return escolaRepository.save(escola);
    }

    public Escola alterar(Integer id, Escola escola) {
        Optional<Escola> escolaData = escolaRepository.findById(id);

        if (escolaData.isPresent()) {
            Escola escolaExistente = escolaData.get();

            escolaExistente.setNome(escola.getNome());
            escolaRepository.save(escolaExistente);

            return escolaExistente;
        } else {
            throw new RuntimeException("Escola não encontrada");
        }
    }

    public String excluir(Integer id) {
        Optional<Escola> escolaData = escolaRepository.findById(id);

        if(escolaData.isPresent()) {
            Escola escolaExistente = escolaData.get();

            escolaRepository.deleteById(escolaExistente.getId());

            return "Escola excluída com sucesso";
        } else {
            throw new RuntimeException("Escola não encontrada");
        }
    }

    public List<Escola> listar() {
        return escolaRepository.findAll();
    }

    public Escola consultar(Integer id) {
        Optional<Escola> escola = escolaRepository.findById(id);
        if(escola.isPresent()) {
            return escola.get();
        } else {
            throw new RuntimeException("Escola não encontrada");
        }
    }
}
