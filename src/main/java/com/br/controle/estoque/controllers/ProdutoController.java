package com.br.controle.estoque.controllers;

import com.br.controle.estoque.dto.ProdutoDTO;
import com.br.controle.estoque.model.Produto;
import com.br.controle.estoque.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("salvar")
    public Produto salvarProduto(@Valid ProdutoDTO produtoDTO){

        Produto produto = produtoDTO.toProduto();

        return this.produtoService.salvar(produto);
    }


}
