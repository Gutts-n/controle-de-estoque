package com.br.controle.estoque.services;

import com.br.controle.estoque.model.Produto;
import com.br.controle.estoque.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos(){
        return this.produtoRepository.findAll();
    }


    public Produto salvar(Produto produto){
        return this.produtoRepository.save(produto);
    }
}
