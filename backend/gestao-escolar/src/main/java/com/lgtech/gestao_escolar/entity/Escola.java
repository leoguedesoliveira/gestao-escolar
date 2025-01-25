package com.lgtech.gestao_escolar.entity;

import com.lgtech.gestao_escolar.dto.EscolaDTO.EscolaRequestDTO;
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
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESCOLA")
    private Integer id;

    @Column(name = "NM_ESCOLA")
    private String nome;

    public Escola(EscolaRequestDTO data) {
        this.nome = data.nome();
    }

    public Escola() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
