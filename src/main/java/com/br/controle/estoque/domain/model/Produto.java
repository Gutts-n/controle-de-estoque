package com.br.controle.estoque.domain.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Estabelecimento estabelecimentoId;

    @ManyToOne
    @JoinColumn(name = "colaborador_que_cadastrou_ou_editou")
    private Colaborador colaboradorId;

    private String nome;

    private BigDecimal quantidade;

    @Enumerated(EnumType.STRING)
    private TipoQuantidade tipoQuantidade;

//    private BigDecimal total;

//    @DecimalMin(value = "0")
//    private BigDecimal preco;


    public Produto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(estabelecimentoId, produto.estabelecimentoId) && Objects.equals(colaboradorId, produto.colaboradorId) && Objects.equals(nome, produto.nome) && Objects.equals(quantidade, produto.quantidade) && tipoQuantidade == produto.tipoQuantidade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estabelecimentoId, colaboradorId, nome, quantidade, tipoQuantidade);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estabelecimento getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public void setEstabelecimentoId(Estabelecimento estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }

    public Colaborador getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Colaborador colaboradorId) {
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

    public Produto(String nome, BigDecimal quantidade, TipoQuantidade tipoQuantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipoQuantidade = tipoQuantidade;
//        this.preco = preco;
//        this.total = this.preco.multiply(new BigDecimal(quantidade));
    }

    public Produto(
            Colaborador colaboradorId,
            Estabelecimento estabelecimentoId,
            String nome,
            BigDecimal quantidade,
            TipoQuantidade tipoQuantidade
    ){
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipoQuantidade = tipoQuantidade;
        this.colaboradorId = colaboradorId;
        this.estabelecimentoId = estabelecimentoId;
    }

}
