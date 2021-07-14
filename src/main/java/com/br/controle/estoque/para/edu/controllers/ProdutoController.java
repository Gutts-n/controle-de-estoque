package com.br.controle.estoque.para.edu.controllers;

import com.br.controle.estoque.para.edu.dto.ProdutoDTO;
import com.br.controle.estoque.para.edu.model.Produto;
import com.br.controle.estoque.para.edu.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("novo")
    public ModelAndView produtoFormulario(ModelAndView view){

        if (view.isEmpty()){
            return this.produtoService.produtoFormulario();
        } else {
            return view;
        }

    }

    @PostMapping("salvar")
    public ModelAndView salvarProduto(@Valid ProdutoDTO produtoDTO){

        Produto produto = produtoDTO.toPedido();

        return this.produtoService.salvar(produto);
    }


}
