package com.br.controle.estoque.error.exceptions;

public class ControleDeEstoqueException extends RuntimeException {

    private String mensagemDesenvolvedor = "Validação efetuada com sucesso.";

    public ControleDeEstoqueException(String message) {
        super(message);
    }

    public ControleDeEstoqueException(String message, String mensagemDesenvolvedor) {
        super(message);
        this.mensagemDesenvolvedor = mensagemDesenvolvedor;
    }

    public String getMensagemDesenvolvedor() {
        return mensagemDesenvolvedor;
    }
}
