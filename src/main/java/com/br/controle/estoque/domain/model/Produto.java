package com.br.controle.estoque.domain.model;

import com.br.controle.estoque.domain.enums.TipoQuantidade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Estabelecimento estabelecimento;

    @ManyToOne
    @JoinColumn(name = "colaborador_que_cadastrou")
    private Colaborador colaboradorQueCadastrou;

    private String nome;

    private BigDecimal quantidade;

    @Enumerated(EnumType.STRING)
    private TipoQuantidade tipoQuantidade;

//    private BigDecimal total;

//    @DecimalMin(value = "0")
//    private BigDecimal preco;

    public Produto() {
    }

    public Produto(String nome, BigDecimal quantidade, TipoQuantidade tipoQuantidade, Colaborador colaboradorQueCadastrou) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipoQuantidade = tipoQuantidade;
        this.colaboradorQueCadastrou = colaboradorQueCadastrou;
//        this.preco = preco;
//        this.total = this.preco.multiply(new BigDecimal(quantidade));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimentoId) {
        this.estabelecimento = estabelecimentoId;
    }

    public Colaborador getColaboradorQueCadastrou() {
        return colaboradorQueCadastrou;
    }

    public void setColaboradorQueCadastrou(Colaborador colaboradorId) {
        this.colaboradorQueCadastrou = colaboradorId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
