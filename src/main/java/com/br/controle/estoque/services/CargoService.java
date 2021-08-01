package com.br.controle.estoque.services;

import com.br.controle.estoque.exceptions.ExceptionGlobal;
import com.br.controle.estoque.model.Cargo;
import com.br.controle.estoque.repositories.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;

    public Cargo salvar(Cargo cargo){
        Optional<Cargo> cargoOptional = cargoRepository.findByNome(cargo.getNome());
        if (cargoOptional.isPresent()){
            throw new ExceptionGlobal("Cargo já foi cadastrado!");
        }
        return cargoRepository.save(cargo);
    }

    public Optional<Cargo> buscarPorNome(String nomeDoCargo) {
        return cargoRepository.findByNome(nomeDoCargo);
    }

    public List<Cargo> buscarTodos() {
        return cargoRepository.findAll();
    }

    public void deletar(Long id) {
        cargoRepository.deleteById(id);
    }
}
