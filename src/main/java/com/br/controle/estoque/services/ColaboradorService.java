package com.br.controle.estoque.services;

import com.br.controle.estoque.domain.model.Cargo;
import com.br.controle.estoque.domain.model.Colaborador;
import com.br.controle.estoque.domain.model.Estabelecimento;
import com.br.controle.estoque.domain.repositories.CargoRepository;
import com.br.controle.estoque.domain.repositories.ColaboradorRepository;
import com.br.controle.estoque.domain.repositories.EstabelecimentoRepository;
import com.br.controle.estoque.error.exceptions.ControleDeEstoqueException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;
    private final EstabelecimentoRepository estabelecimentoRepository;
    private final CargoRepository cargoRepository;

    public ColaboradorService(ColaboradorRepository colaboradorRepository, EstabelecimentoRepository estabelecimentoRepository, CargoRepository cargoRepository) {
        this.colaboradorRepository = colaboradorRepository;
        this.estabelecimentoRepository = estabelecimentoRepository;
        this.cargoRepository = cargoRepository;
    }

    public Colaborador salvar(Colaborador colaborador){

        Optional<Colaborador> colaboradorOptional = buscarColaborador(colaborador);
        Optional<Estabelecimento> estabOptional = buscarEstab(colaborador.getEstabelecimento());
        Optional<Cargo> cargoOptional = buscarCargo(colaborador.getCargo());

        if (colaboradorOptional.isPresent()){
            throw new ControleDeEstoqueException("Colaborador já cadastrado!");
        }

        if (estabOptional.isEmpty()){
            throw new ControleDeEstoqueException("Estabelecimento não cadastrado!");
        }

        if (cargoOptional.isEmpty()){
            throw new ControleDeEstoqueException("Cargo não cadastrado!");
        }

        return colaboradorRepository.save(colaborador);
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

    private Optional<Cargo> buscarCargo(Cargo cargo) {
        return cargoRepository.findById(cargo.getId());
    }

    private Optional<Estabelecimento> buscarEstab(Estabelecimento estabelecimento) {
        return estabelecimentoRepository.findById(estabelecimento.getId());
    }

    public List<Colaborador> buscarTodos() {
        return colaboradorRepository.findAll();
    }

    private Optional<Colaborador> buscarColaborador(Colaborador colaborador){
        return colaboradorRepository.findByNomeCargoAndEstab(
                colaborador.getNome(),
                colaborador.getCargo(),
                colaborador.getEstabelecimento());
    }

}
