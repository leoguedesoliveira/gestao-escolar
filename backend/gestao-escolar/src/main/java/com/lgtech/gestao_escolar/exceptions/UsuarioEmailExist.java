package com.lgtech.gestao_escolar.exceptions;

public class UsuarioEmailExist extends RuntimeException {

    public UsuarioEmailExist() {
        super("Esse e-mail já está sendo utilizado");
    }

    public UsuarioEmailExist(String message) {
        super(message);
    }
}
