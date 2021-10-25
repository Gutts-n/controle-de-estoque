package com.br.controle.estoque.domain.dto;

import com.br.controle.estoque.annotations.TipoQuantidadePattern;
import com.br.controle.estoque.domain.model.Colaborador;
import com.br.controle.estoque.domain.model.Produto;
import com.br.controle.estoque.domain.enums.TipoQuantidade;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ProdutoDTO {

    @NotNull
    private Long estabId;

    @NotNull
    private Long colaboradorId;

    @NotBlank
    @Size(min = 5, max = 300)
    private String nome;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("1000000")
    private BigDecimal quantidade;

//    @NotNull
//    @DecimalMin(value = "0.5")
//    @DecimalMax(value = "1000000")
//    private BigDecimal preco;

    @NotNull
    @TipoQuantidadePattern(regexp = "KG|UN")
    private TipoQuantidade tipoQuantidade;

    public Produto toProduto(){
        return new Produto(nome, quantidade, tipoQuantidade, new Colaborador(colaboradorId));
    }

    public Long getEstabId() {
        return estabId;
    }

    public void setEstabId(Long estabId) {
        this.estabId = estabId;
    }

    public Long getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Long colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public TipoQuantidade getTipoQuantidade() {
        return tipoQuantidade;
    }

    public void setTipoQuantidade(TipoQuantidade tipoQuantidade) {
        this.tipoQuantidade = tipoQuantidade;
    }
}
