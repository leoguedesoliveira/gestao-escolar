package com.lgtech.schoolpro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "ENDERECOS")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENDERECO")
    private Integer ID_ENDERECO;
    @Column(name = "CD_CEP")
    private String CD_CEP;
    @Column(name = "NM_LOGRADOURO")
    private String NM_LOGRADOURO;
    @Column(name = "NR_NUMERO")
    private Integer NR_NUMERO;
    @Column(name = "NM_COMPLEMENTO")
    private String NM_COMPLEMENTO;
    @Column(name = "NM_REFERENCIA")
    private String NM_REFERENCIA;
    @Column(name = "NM_BAIRRO")
    private String NM_BAIRRO;
    @Column(name = "NM_CIDADE")
    private String NM_CIDADE;
    @ManyToOne
    @JoinColumn(name = "ID_ESCOLA", referencedColumnName = "ID_ESCOLA", nullable = false)
    private Escola ID_ESCOLA;
    @Column(name = "ID_UNIDADE")
    private Integer ID_UNIDADE;

}
