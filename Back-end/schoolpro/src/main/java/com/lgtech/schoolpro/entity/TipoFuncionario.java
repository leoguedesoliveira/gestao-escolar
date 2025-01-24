package com.lgtech.schoolpro.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

public class TipoFuncionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_FUNCIONARIO")
    private Integer id;

    @Column(name = "NM_TIPO_FUNCIONARIO")
    private String nome;

    @Column(name = "DS_TIPO_FUNCIONARIO")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "ID_ESCOLA", referencedColumnName = "ID_ESCOLA", nullable = false)
    private Escola escola;

    @Column(name = "ID_UNIDADE")
    private Integer unidade;
}