package com.br.controle.estoque.controllers;

import com.br.controle.estoque.dto.ColaboradorDTO;
import com.br.controle.estoque.exceptionUtils.ExceptionUtils;
import com.br.controle.estoque.exceptions.ExceptionGlobal;
import com.br.controle.estoque.model.Colaborador;
import com.br.controle.estoque.services.ColaboradorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("colaborador")
@AllArgsConstructor
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @PostMapping
    public Colaborador salvarColaborador(@Valid @RequestBody ColaboradorDTO colaboradorDTO){

        try {
            return this.colaboradorService.salvar(colaboradorDTO.toColaborador());
        } catch (ExceptionGlobal exception){
            throw ExceptionUtils.retornarErroAoUsuario(exception);
        }
    }

    @PutMapping("/{id}")
    public Colaborador atualizarColaborador(@PathVariable Long id, @Valid @RequestBody ColaboradorDTO colaboradorDTO){
        try {
            return this.colaboradorService.atualizar(id, colaboradorDTO.toColaborador());
        } catch (ExceptionGlobal exception){
            throw ExceptionUtils.retornarErroAoUsuario(exception);
        }
    }

}
