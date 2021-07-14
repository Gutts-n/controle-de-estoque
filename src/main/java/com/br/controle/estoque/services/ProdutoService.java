package com.br.controle.estoque.services;

import com.br.controle.estoque.model.Produto;
import com.br.controle.estoque.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ModelAndView listarProdutos(){
        ModelAndView home = new ModelAndView("home");

        List<Produto> produtos = this.produtoRepository.findAll();

        if (produtos.isEmpty()){
            return home.addObject("produtos", Collections.emptyList());
        } else {
            return home.addObject("produtos", produtos);
        }
    }


    public ModelAndView produtoFormulario() {
        ModelAndView formulario = new ModelAndView("produto/produto-formulario");
        formulario.addObject("produto", new Produto());
        return formulario;
    }

    public ModelAndView salvar(Produto produto){
        Produto produtoSalvo = this.produtoRepository.save(produto);

        ModelAndView formularioPraEditar = new ModelAndView("produto/produto-formulario");
        formularioPraEditar.addObject(produtoSalvo);
        return formularioPraEditar;
    }
}
