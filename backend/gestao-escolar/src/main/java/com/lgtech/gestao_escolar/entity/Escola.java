package com.lgtech.gestao_escolar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "ESCOLAS")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESCOLA")
    private Integer id;

    @Column(name = "NM_ESCOLA")
    private String nome;
}
