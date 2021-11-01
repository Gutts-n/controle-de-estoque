package com.br.controle.estoque.controllers;

import com.br.controle.estoque.domain.dto.ColaboradorDTO;
import com.br.controle.estoque.domain.model.Colaborador;
import com.br.controle.estoque.services.ColaboradorService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("colaborador")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @PostMapping
    public Colaborador salvar(@Valid @RequestBody ColaboradorDTO colaboradorDTO){
        return colaboradorService.salvar(colaboradorDTO.toColaborador());
    }

    @PutMapping("/{id}")
    public Colaborador atualizar(@PathVariable Long id, @Valid @RequestBody ColaboradorDTO colaboradorDTO){
        return colaboradorService.atualizar(id, colaboradorDTO.toColaborador());
    }

}
