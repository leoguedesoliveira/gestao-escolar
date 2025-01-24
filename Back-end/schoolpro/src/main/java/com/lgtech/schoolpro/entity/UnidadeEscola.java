package com.lgtech.schoolpro.entity;

import jakarta.persistence.*;

@Table(name = "UNIDADES_ESCOLAS")
@Entity
public class UnidadeEscola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_UNIDADE")
    private Integer ID_UNIDADE;
    @ManyToOne
    @JoinColumn(name = "ID_ESCOLA", referencedColumnName = "ID_ESCOLA", nullable = false)
    private Escola ID_ESCOLA;
    @Column(name = "NM_UNIDADE", nullable = false)
    private String NM_UNIDADE;
}
