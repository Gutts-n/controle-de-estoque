package com.br.controle.estoque.services;

import com.br.controle.estoque.domain.model.EstatitisticaDiariaProduto;
import com.br.controle.estoque.domain.repositories.EstatitisticaDiariaProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class EstatisticaDiariaProdutoService {

    private final EstatitisticaDiariaProdutoRepository estatitisticaDiariaProdutoRepository;

    public EstatisticaDiariaProdutoService(EstatitisticaDiariaProdutoRepository estatitisticaDiariaProdutoRepository) {
        this.estatitisticaDiariaProdutoRepository = estatitisticaDiariaProdutoRepository;
    }

    public EstatitisticaDiariaProduto salvar(EstatitisticaDiariaProduto estatitisticaDiariaProduto){
        return estatitisticaDiariaProdutoRepository.save(estatitisticaDiariaProduto);
    }

}
