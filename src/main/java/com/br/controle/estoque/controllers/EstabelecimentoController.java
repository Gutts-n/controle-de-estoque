package com.br.controle.estoque.controllers;

import com.br.controle.estoque.domain.dto.EstabelecimentoDTO;
import com.br.controle.estoque.domain.model.Estabelecimento;
import com.br.controle.estoque.domain.repositories.EstabelecimentoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("estab")
public class EstabelecimentoController {

    private final EstabelecimentoRepository estabelecimentoRepository;

    public EstabelecimentoController(EstabelecimentoRepository estabelecimentoRepository) {
        this.estabelecimentoRepository = estabelecimentoRepository;
    }

    @PostMapping
    public Estabelecimento salvar(@Valid @RequestBody EstabelecimentoDTO estabelecimentoDTO){
        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setNome(estabelecimentoDTO.getNome());
        return estabelecimentoRepository.save(estabelecimento);
    }

}
