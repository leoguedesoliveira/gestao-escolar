package com.lgtech.schoolpro.entity;

import jakarta.persistence.*;

import java.util.Date;

public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FUNCIONARIO")
    private Integer id;

    @Column(name = "NM_FUNCIONARIO", nullable = false)
    private String nome;

    @Column(name = "CD_CPF", nullable = false)
    private String cpf;

    @Column(name = "CD_RG")
    private String rg;

    @Column(name = "DT_NASCIMENTO", nullable = false)
    private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO", nullable = false)
    private Endereco endereco;

    @Column(name = "VL_SALARIO")
    private Float salario;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_FUNCIONARIO", referencedColumnName = "ID_TIPO_FUNCIONARIO", nullable = false)
    private TipoFuncionario tipoFuncionario;

    @ManyToOne
    @JoinColumn(name = "ID_ESCOLA", referencedColumnName = "ID_ESCOLA", nullable = false)
    private Escola escola;

    @Column(name = "ID_UNIDADE")
    private Integer unidade;
}
