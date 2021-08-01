package com.br.controle.estoque.controllers;

import com.br.controle.estoque.exceptionUtils.ExceptionUtils;
import com.br.controle.estoque.exceptions.ExceptionGlobal;
import com.br.controle.estoque.model.Cargo;
import com.br.controle.estoque.services.CargoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cargo")
@AllArgsConstructor
public class CargoController {

    private final CargoService cargoService;

    @GetMapping
    public List<Cargo> listarCargos(){
        return cargoService.buscarTodos();
    }

    @PostMapping
    public Cargo salvarCargo(@Valid @RequestBody Cargo cargo){
        try {
            return cargoService.salvar(cargo);
        } catch (ExceptionGlobal exception){
            throw ExceptionUtils.retornarErroAoUsuario(exception);
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCargo(@PathVariable Long id){
        this.cargoService.deletar(id);
    }
}
