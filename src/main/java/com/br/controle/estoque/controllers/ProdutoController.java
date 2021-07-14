package com.br.controle.estoque.controllers;

import com.br.controle.estoque.dto.ProdutoDTO;
import com.br.controle.estoque.model.Produto;
import com.br.controle.estoque.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    public ModelAndView salvarProduto(@Valid ProdutoDTO produtoDTO, BindingResult resultadoDosErros){

        if (resultadoDosErros.hasErrors()){
//            Map<String, Object> produtoAndErros = new HashMap<>();
//            produtoAndErros.put("produto", new Produto();
//            produtoAndErros.put("erros", resultadoDosErros);

            return new ModelAndView("produto/produto-formulario")
                    .addObject(resultadoDosErros);
        }

        Produto produto = produtoDTO.toProduto();

        return this.produtoService.salvar(produto);
    }


}
