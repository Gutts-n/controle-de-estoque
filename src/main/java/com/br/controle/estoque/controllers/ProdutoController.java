package com.br.controle.estoque.controllers;

import com.br.controle.estoque.dto.ProdutoDTO;
import com.br.controle.estoque.exceptionUtils.ExceptionUtils;
import com.br.controle.estoque.exceptions.ExceptionGlobal;
import com.br.controle.estoque.model.Produto;
import com.br.controle.estoque.repositories.ProdutoRepository;
import com.br.controle.estoque.services.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ProdutoRepository produtoRepository;

    @PostMapping
    public Produto salvar(@RequestBody @Valid ProdutoDTO produtoDTO){

        try{
            return this.produtoService.salvar(produtoDTO.toProduto());
        }
        catch (ExceptionGlobal exceptionGlobal){
            throw ExceptionUtils.retornarErroAoUsuario(exceptionGlobal);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@RequestParam Long id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@RequestParam Long id, @Valid @RequestBody ProdutoDTO produtoDTO){

        try {
            return produtoService.atualizar(id, produtoDTO.toProdutoComColaboradorEEstabelecimento());
        } catch (ExceptionGlobal exceptionGlobal){
            throw ExceptionUtils.retornarErroAoUsuario(exceptionGlobal);
        }
    }


}
