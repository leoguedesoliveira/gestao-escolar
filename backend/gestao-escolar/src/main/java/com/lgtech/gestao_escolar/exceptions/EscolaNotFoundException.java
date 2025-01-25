package com.lgtech.gestao_escolar.exceptions;

public class EscolaNotFoundException extends RuntimeException {

    public EscolaNotFoundException() { super("Escola não encontrada"); }

    public EscolaNotFoundException(String message) { super(message); }
}
