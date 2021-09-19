package com.br.controle.estoque.services;

import com.br.controle.estoque.domain.model.Cargo;
import com.br.controle.estoque.domain.model.Colaborador;
import com.br.controle.estoque.domain.repositories.ColaboradorRepository;
import com.br.controle.estoque.error.exceptions.ControleDeEstoqueException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;
    private final CargoService cargoService;

    public ColaboradorService(ColaboradorRepository colaboradorRepository, CargoService cargoService) {
        this.colaboradorRepository = colaboradorRepository;
        this.cargoService = cargoService;
    }

    public Colaborador salvar(Colaborador colaborador){

        Optional<Cargo> optionalCargo = cargoService.buscarPorNome(colaborador.getCargo().getNome());

        if (optionalCargo.isEmpty()) {
            Cargo cargo = cargoService.salvar(colaborador.getCargo());
            colaborador.setCargo(cargo);
        } else {
            colaborador.setCargo(optionalCargo.get());
        }

        Optional<Colaborador> colaboradorOptional = buscarColaborador(colaborador);

        if (colaboradorOptional.isPresent()){
            throw new ControleDeEstoqueException("Colaborador já cadastrado!");
        }

        return colaboradorRepository.save(colaborador);

    }

    private Optional<Colaborador> buscarColaborador(Colaborador colaborador){
        return colaboradorRepository.
                findByNomeAndCargo(colaborador.getNome(), colaborador.getCargo());
    }

    public Colaborador atualizar(Long id, Colaborador colaborador) {


        Optional<Colaborador> colaboradorOptional = colaboradorRepository.findById(id);

        if (colaboradorOptional.isPresent()){
            Colaborador colaboradorCadastrado = colaboradorOptional.get();
            BeanUtils.copyProperties(colaborador, colaboradorCadastrado, "id");
            return colaboradorRepository.save(colaborador);
        }
        throw new ControleDeEstoqueException("Não foi possível atualizar pois o colaborador em questão não tem cadastrado!");

    }
}