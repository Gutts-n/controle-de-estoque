package com.br.controle.estoque.services;

import com.br.controle.estoque.domain.model.Cargo;
import com.br.controle.estoque.domain.repositories.CargoRepository;
import com.br.controle.estoque.error.exceptions.ControleDeEstoqueException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public Cargo salvar(Cargo cargo){
        Optional<Cargo> cargoOptional = cargoRepository.findByNome(cargo.getNome());
        if (cargoOptional.isPresent()){
            throw new ControleDeEstoqueException("Cargo já foi cadastrado!");
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
