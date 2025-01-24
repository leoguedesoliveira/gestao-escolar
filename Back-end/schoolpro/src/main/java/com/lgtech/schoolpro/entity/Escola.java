package com.lgtech.schoolpro.entity;

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
    private Integer ID_ESCOLA;
    @Column(name = "NM_ESCOLA", nullable = false)
    private String NM_ESCOLA;

}
