package com.br.controle.estoque.dto;

import com.br.controle.estoque.annotations.TipoQuantidadePattern;
import com.br.controle.estoque.model.Produto;
import com.br.controle.estoque.model.TipoQuantidade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoAtualizarDTO {

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataAlteracao;

    @NotNull
    private Long colaboradorId;

    @NotNull
    private BigDecimal quantidadeAlterada;

    @NotNull
    private Long estabelecimentoId;

    @NotBlank
    @Size(min = 5, max = 300)
    private String nome;

    @NotNull
    @TipoQuantidadePattern(regexp = "KG|UN")
    private TipoQuantidade tipoQuantidade;

    public Produto toProduto() {
        return new Produto();
    }
}
