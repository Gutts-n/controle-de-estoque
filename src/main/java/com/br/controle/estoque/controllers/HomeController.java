package com.br.controle.estoque.controllers;

import com.br.controle.estoque.model.Produto;
import com.br.controle.estoque.services.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private final ProdutoService produtoService;

    public HomeController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return this.produtoService.listarProdutos();
    }
}