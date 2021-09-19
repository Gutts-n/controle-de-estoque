package com.br.controle.estoque.services;

import com.br.controle.estoque.domain.model.Produto;
import com.br.controle.estoque.domain.repositories.ProdutoRepository;
import com.br.controle.estoque.error.exceptions.ControleDeEstoqueException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Produto atualizar(Long id, Produto produto) {

        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isPresent()){
            Produto produtoCadastrado = produtoOptional.get();
            BeanUtils.copyProperties(produto, produtoCadastrado, "id");
            return produtoRepository.save(produto);
        }
        throw new ControleDeEstoqueException("Não foi possível atualizar o produto pois o produto não está cadastrado!");
    }
}
