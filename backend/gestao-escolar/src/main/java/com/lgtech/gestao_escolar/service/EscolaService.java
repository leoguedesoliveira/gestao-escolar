package com.lgtech.gestao_escolar.service;


import com.lgtech.gestao_escolar.dto.EscolaDTO.EscolaRequestDTO;
import com.lgtech.gestao_escolar.entity.Escola;
import com.lgtech.gestao_escolar.exceptions.EscolaExistException;
import com.lgtech.gestao_escolar.exceptions.EscolaNotFoundException;
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

    public Escola inserir(EscolaRequestDTO escola) {
        if( escolaRepository.findByNome(escola.nome()).isPresent() ) {
            throw new EscolaExistException();
        } else {
            Escola escolaData = new Escola(escola);
            return escolaRepository.save(escolaData);
        }
    }

    public Escola alterar(Integer id, EscolaRequestDTO escola) {
        Optional<Escola> escolaData = escolaRepository.findById(id);

        if (escolaData.isPresent()) {
            Escola escolaExistente = escolaData.get();

            escolaExistente.setNome(escola.nome());
            escolaRepository.save(escolaExistente);

            return escolaExistente;
        } else {
            throw new EscolaNotFoundException();
        }
    }

    public String excluir(Integer id) {
        Optional<Escola> escolaData = escolaRepository.findById(id);

        if(escolaData.isPresent()) {
            Escola escolaExistente = escolaData.get();

            escolaRepository.deleteById(escolaExistente.getId());

            return "Escola excluída com sucesso";
        } else {
            throw new EscolaNotFoundException();
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
            throw new EscolaNotFoundException();
        }
    }
}
