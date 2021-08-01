package com.br.controle.estoque.services;

import com.br.controle.estoque.model.EstatitisticaDiariaProduto;
import com.br.controle.estoque.repositories.EstatitisticaDiariaProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstatisticaDiariaProdutoService {

    private final EstatitisticaDiariaProdutoRepository estatitisticaDiariaProdutoRepository;

    public EstatitisticaDiariaProduto salvar(EstatitisticaDiariaProduto estatitisticaDiariaProduto){
        return estatitisticaDiariaProdutoRepository.save(estatitisticaDiariaProduto);
    }

}
