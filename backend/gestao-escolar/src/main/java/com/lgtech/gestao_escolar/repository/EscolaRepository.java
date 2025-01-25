package com.lgtech.gestao_escolar.repository;

import com.lgtech.gestao_escolar.entity.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EscolaRepository extends JpaRepository<Escola, Integer> {
    Optional<Escola> findByNome(String nome);
}
