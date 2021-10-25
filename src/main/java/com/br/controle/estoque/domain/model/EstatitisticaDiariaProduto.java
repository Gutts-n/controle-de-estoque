package com.br.controle.estoque.domain.model;

import com.br.controle.estoque.domain.enums.AumentouDiminuiu;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "produto_alterado_no_dia")
public class EstatitisticaDiariaProduto {

    @Id
    private LocalDateTime dataAlteracao;

    @OneToOne
    private Colaborador colaboradorQueAlterou;

    @OneToOne
    private Produto produtoAlterado;

    @OneToOne
    private Estabelecimento estabId;

    private BigDecimal quantidadeAlterada;

    @Enumerated(EnumType.STRING)
    private AumentouDiminuiu aumentouOuDiminuiu;

    public EstatitisticaDiariaProduto() {
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public AumentouDiminuiu getAumentouOuDiminuiu() {
        return aumentouOuDiminuiu;
    }

    public void setAumentouOuDiminuiu(AumentouDiminuiu aumentouOuDiminuiu) {
        this.aumentouOuDiminuiu = aumentouOuDiminuiu;
    }

    public Colaborador getColaboradorQueAlterou() {
        return colaboradorQueAlterou;
    }

    public void setColaboradorQueAlterou(Colaborador colaboradorId) {
        this.colaboradorQueAlterou = colaboradorId;
    }

    public Produto getProdutoAlterado() {
        return produtoAlterado;
    }

    public void setProdutoAlterado(Produto produtoId) {
        this.produtoAlterado = produtoId;
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
