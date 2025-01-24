package com.lgtech.schoolpro.entity;

import com.lgtech.schoolpro.dto.UsuarioDTO.UsuarioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table(name = "USUARIOS")
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Usuario {

    public Usuario(UsuarioRequestDTO data) {
        this.nome = data.nome();
        this.login = data.login();
        this.senha = data.senha();
        this.email = data.email();
        this.escola = data.escola();
        this.unidade = data.unidade();
    }

    public Usuario() {

    }

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Integer id;

    @Column(name = "NM_USUARIO", nullable = false)
    private String nome;

    @Column(name = "NM_LOGIN", nullable = false)
    private String login;

    @Column(name = "DS_SENHA", nullable = false)
    private String senha;

    @Column(name = "DS_EMAIL")
    private String email;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
