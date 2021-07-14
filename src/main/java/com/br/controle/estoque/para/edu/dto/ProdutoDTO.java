package com.br.controle.estoque.para.edu.dto;

import com.br.controle.estoque.para.edu.annotations.TipoQuantidadePattern;
import com.br.controle.estoque.para.edu.model.Produto;
import com.br.controle.estoque.para.edu.model.TipoQuantidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    @NotBlank
    private String nomeProduto;

    @NotNull
    @Min(0)
    private Integer quantidade;

    @NotNull
    @DecimalMin(value = "0.10")
    private BigDecimal preco;

    @NotNull
    @TipoQuantidadePattern(regexp = "KG|UN")
    private TipoQuantidade tipoQuantidade;

    public Produto toPedido(){
        return new Produto(nomeProduto, quantidade, preco, tipoQuantidade);
    }

}