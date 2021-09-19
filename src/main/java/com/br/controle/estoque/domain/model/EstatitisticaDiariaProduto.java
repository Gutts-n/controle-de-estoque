package com.br.controle.estoque.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "produto_alterado_no_dia")
public class EstatitisticaDiariaProduto {

    @Id
    private LocalDateTime dataAlteracao;

    @OneToOne
    private Colaborador colaboradorId;

    @OneToOne
    private Produto produtoId;

    @OneToOne
    private Estabelecimento estabId;

    private BigDecimal quantidadeAlterada;

    public EstatitisticaDiariaProduto() {
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
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
