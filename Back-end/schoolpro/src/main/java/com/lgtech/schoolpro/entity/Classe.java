package com.lgtech.schoolpro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLASSE")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_FUNCIONARIO", nullable = false)
    private Funcionario funcionario;

    @Column(name = "NM_CLASSE", nullable = false)
    private String nome;

    @Column(name = "DS_CLASSE")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "ID_ESCOLA", referencedColumnName = "ID_ESCOLA", nullable = false)
    private Escola escola;
    private Integer unidade;
}
