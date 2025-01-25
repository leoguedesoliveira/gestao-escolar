package com.lgtech.gestao_escolar.entity;

public enum UsuarioRole {
    ADMIN("admin"),
    DIRECTOR("director"),
    USER("user");

    private String role;

    UsuarioRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
