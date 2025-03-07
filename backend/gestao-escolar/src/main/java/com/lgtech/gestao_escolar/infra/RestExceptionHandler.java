package com.lgtech.gestao_escolar.infra;

import com.lgtech.gestao_escolar.exceptions.EscolaExistException;
import com.lgtech.gestao_escolar.exceptions.EscolaNotFoundException;
import com.lgtech.gestao_escolar.exceptions.UsuarioEmailExist;
import com.lgtech.gestao_escolar.exceptions.UsuarioNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EscolaNotFoundException.class)
    private ResponseEntity<String> escolaNotFoundHandler(EscolaNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Escola não encontrada");
    }

    @ExceptionHandler(EscolaExistException.class)
    private ResponseEntity<String> escolaExistHandler(EscolaExistException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já existe uma escola com esse nome cadastrada");
    }

    @ExceptionHandler(UsuarioEmailExist.class)
    private ResponseEntity<String> suarioEmailExist(UsuarioEmailExist exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esse e-mail já está sendo utilizado");
    }

    @ExceptionHandler(UsuarioNotFound.class)
    private ResponseEntity<String> suarioEmailExist(UsuarioNotFound exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
    }

}

