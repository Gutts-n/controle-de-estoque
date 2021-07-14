package com.br.controle.estoque.para.edu.controllers;

import com.br.controle.estoque.para.edu.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final ProdutoService produtoService;

    public HomeController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ModelAndView listarProdutos(){
        return this.produtoService.listarProdutos();
    }
}
