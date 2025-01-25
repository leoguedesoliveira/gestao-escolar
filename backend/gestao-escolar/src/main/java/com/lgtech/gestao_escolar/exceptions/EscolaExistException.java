package com.lgtech.gestao_escolar.exceptions;

public class EscolaExistException extends RuntimeException {

  public EscolaExistException() {
    super("Já existe uma escola com esse nome");
  }

  public EscolaExistException(String message) {
        super(message);
    }
}
