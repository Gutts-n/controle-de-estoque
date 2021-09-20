package com.br.controle.estoque.error.exceptionHandler;

import com.br.controle.estoque.error.exceptions.ControleDeEstoqueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerExcecoes extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ControleDeEstoqueException.class})
    private ResponseEntity<Object> tratarExcecao(ControleDeEstoqueException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
