package com.br.controle.estoque.dto;

import com.br.controle.estoque.annotations.TipoQuantidadePattern;
import com.br.controle.estoque.exceptions.ExceptionGlobal;
import com.br.controle.estoque.model.Colaborador;
import com.br.controle.estoque.model.Estabelecimento;
import com.br.controle.estoque.model.Produto;
import com.br.controle.estoque.model.TipoQuantidade;
import com.br.controle.estoque.repositories.ColaboradorRepository;
import com.br.controle.estoque.repositories.EstabelecimentoRepository;
import lombok.AllArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@AllArgsConstructor
public class ProdutoDTO {

    private final ColaboradorRepository colaboradorRepository;
    private final EstabelecimentoRepository estabelecimentoRepository;

    @NotNull
    private Long estabId;

    @NotNull
    private Long colaboradorId;

    public ProdutoDTO(ColaboradorRepository colaboradorRepository, EstabelecimentoRepository estabelecimentoRepository) {
        this.colaboradorRepository = colaboradorRepository;
        this.estabelecimentoRepository = estabelecimentoRepository;
    }

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
        return new Produto(nome, quantidade, tipoQuantidade);
    }

    public Produto toProdutoComColaboradorEEstabelecimento(){

        Colaborador colaborador = colaboradorRepository.getById(colaboradorId);
        Estabelecimento estabelecimento = estabelecimentoRepository.getById(estabId);
        if (colaborador == null || estabelecimento == null){
            throw new ExceptionGlobal("Estabelecimento e colaborador são obrigatórios");
        }
        return new Produto(colaborador, estabelecimento, nome, quantidade, tipoQuantidade);
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
