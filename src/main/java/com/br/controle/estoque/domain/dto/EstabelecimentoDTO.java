package com.br.controle.estoque.domain.dto;

import com.br.controle.estoque.domain.model.Estabelecimento;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class EstabelecimentoDTO {

    private Long id;

    @NotBlank
    @Min(3)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
