package com.lgtech.gestao_escolar.exceptions;

public class LoginInvalidoExcepition extends RuntimeException {

    public LoginInvalidoExcepition() {
        super("Usuário ou senha inválidos");
    }

    public LoginInvalidoExcepition(String message) {
        super(message);
    }

}
