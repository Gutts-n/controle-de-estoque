package com.br.controle.estoque.controllers;

import com.br.controle.estoque.domain.model.Cargo;
import com.br.controle.estoque.services.CargoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cargo")
public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping
    public List<Cargo> listarCargos(){
        return cargoService.buscarTodos();
    }

    @PostMapping
    public Cargo salvarCargo(@Valid @RequestBody Cargo cargo){
        return cargoService.salvar(cargo);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCargo(@PathVariable Long id){
        cargoService.deletar(id);
    }
}
