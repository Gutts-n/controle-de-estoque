package com.br.controle.estoque.para.edu.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private Integer quantidade;

    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private TipoQuantidade tipoQuantidade;

    @DecimalMin(value = "0")
    private BigDecimal preco;

    public Produto(String nome, Integer quantidade, BigDecimal preco, TipoQuantidade tipoQuantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.tipoQuantidade = tipoQuantidade;
        this.total = this.preco.multiply(new BigDecimal(quantidade));
    }

}
