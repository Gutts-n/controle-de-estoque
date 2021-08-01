package com.br.controle.estoque.exceptionUtils;

import com.br.controle.estoque.exceptions.ExceptionGlobal;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ExceptionUtils {

    public static ResponseStatusException retornarErroAoUsuario(ExceptionGlobal exceptionGlobal) {
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                exceptionGlobal.getMessage());
    }

}
