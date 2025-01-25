package com.lgtech.gestao_escolar.exceptions;

public class UsuarioNotFound extends RuntimeException {

    public UsuarioNotFound() {
        super("Usuário não encontrado");
    }

    public UsuarioNotFound(String message) {
        super(message);
    }
}
