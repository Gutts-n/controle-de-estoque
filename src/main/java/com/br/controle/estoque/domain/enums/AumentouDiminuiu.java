package com.br.controle.estoque.domain.enums;

import com.br.controle.estoque.error.exceptions.ControleDeEstoqueException;

import java.util.Objects;

public enum AumentouDiminuiu {
    AUMENTOU('+'),
    DIMINUIU('-');

    private final Character simbolo;

    AumentouDiminuiu(Character simbolo) {
        this.simbolo = simbolo;
    }

    public static AumentouDiminuiu aumentouOuDiminuiu(Character simbolo){
        if (Objects.nonNull(simbolo)){
            return AumentouDiminuiu.AUMENTOU.simbolo == simbolo ? AumentouDiminuiu.AUMENTOU : AumentouDiminuiu.DIMINUIU;
        }
        throw new ControleDeEstoqueException("Simbolo inválido");
    }

    public Character getSimbolo() {
        return simbolo;
    }
}
