package com.br.controle.estoque.controllers;

import com.br.controle.estoque.domain.dto.ProdutoDTO;
import com.br.controle.estoque.domain.model.Produto;
import com.br.controle.estoque.domain.repositories.ProdutoRepository;
import com.br.controle.estoque.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoService produtoService, ProdutoRepository produtoRepository) {
        this.produtoService = produtoService;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody @Valid ProdutoDTO produtoDTO){
        return produtoService.salvar(produtoDTO.toProduto());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @Valid @RequestBody ProdutoDTO produtoDTO){
        return produtoService.atualizar(id, produtoDTO.toProduto());
    }

}
