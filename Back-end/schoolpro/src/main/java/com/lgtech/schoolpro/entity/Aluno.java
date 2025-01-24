package com.lgtech.schoolpro.entity;

import com.lgtech.schoolpro.dto.AlunoDTO.AlunoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "ALUNOS")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Aluno {

    public Aluno(AlunoRequestDTO data) {
        this.nome = data.nome();
        this.dataNacimento = data.dataNascimento();
        this.endereco = data.endereco();
        this.nomeMae = data.nomeMae();
        this.nomePai = data.nomePai();
        this.ra = data.ra();
        this.classe = data.classe();
        this.matriculado = data.matriculado();
        this.dataMatricula = data.dataMatricula();
        this.dataRematricula = data.dataRematricula();
        this.telefone1 = data.telefone1();
        this.telefone2 = data.telefone2();
        this.telefone3 = data.telefone3();
        this.escola = data.escola();
        this.unidade = data.unidade();
    }

    public Aluno() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALUNO")
    private Integer id;

    @Column(name = "NM_ALUNO", nullable = false)
    private String nome;

    @Column(name = "DT_NASCIMENTO", nullable = false)
    private Date dataNacimento;

    @ManyToOne
    @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO", nullable = false)
    private Endereco endereco;

    @Column(name = "NM_MAE", nullable = false)
    private String nomeMae;

    @Column(name = "NM_PAI", nullable = false)
    private String nomePai;

    @Column(name = "CD_RA")
    private String ra;

    @Column(name = "ID_CLASSE", nullable = false)
    private Classe classe;

    @Column(name = "IC_MATRICULADO", nullable = false)
    private String matriculado;

    @Column(name = "DT_MATRICULA", nullable = false)
    private Date dataMatricula;

    @Column(name = "DT_REMATRICULA")
    private Date dataRematricula;

    @Column(name = "DS_TELEFONE_1", nullable = false)
    private String telefone1;

    @Column(name = "DS_TELEFONE_2")
    private String telefone2;

    @Column(name = "DS_TELEFONE_3")
    private String telefone3;

    @ManyToOne
    @JoinColumn(name = "ID_ESCOLA", referencedColumnName = "ID_ESCOLA", nullable = false)
    private Escola escola;

    @Column(name = "ID_UNIDADE")
    private Integer unidade;

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

    public Date getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(Date dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String getMatriculado() {
        return matriculado;
    }

    public void setMatriculado(String matriculado) {
        this.matriculado = matriculado;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Date getDataRematricula() {
        return dataRematricula;
    }

    public void setDataRematricula(Date dataRematricula) {
        this.dataRematricula = dataRematricula;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public Integer getUnidade() {
        return unidade;
    }

    public void setUnidade(Integer unidade) {
        this.unidade = unidade;
    }
}
