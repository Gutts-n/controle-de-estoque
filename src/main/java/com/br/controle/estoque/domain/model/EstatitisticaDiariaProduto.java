package com.br.controle.estoque.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "produto_alterado_no_dia")
public class EstatitisticaDiariaProduto {

    @Id
    private LocalDate dataAlteracao;

    @OneToOne
    private Colaborador colaboradorId;

    @OneToOne
    private Produto produtoId;

    @OneToOne
    private Estabelecimento estabId;

    private BigDecimal quantidadeAlterada;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstatitisticaDiariaProduto that = (EstatitisticaDiariaProduto) o;
        return Objects.equals(dataAlteracao, that.dataAlteracao) && Objects.equals(colaboradorId, that.colaboradorId) && Objects.equals(produtoId, that.produtoId) && Objects.equals(estabId, that.estabId) && Objects.equals(quantidadeAlterada, that.quantidadeAlterada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataAlteracao, colaboradorId, produtoId, estabId, quantidadeAlterada);
    }

    public EstatitisticaDiariaProduto() {
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Colaborador getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Colaborador colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    public Estabelecimento getEstabId() {
        return estabId;
    }

    public void setEstabId(Estabelecimento estabId) {
        this.estabId = estabId;
    }

    public BigDecimal getQuantidadeAlterada() {
        return quantidadeAlterada;
    }

    public void setQuantidadeAlterada(BigDecimal quantidadeBaixada) {
        this.quantidadeAlterada = quantidadeBaixada;
    }
}
