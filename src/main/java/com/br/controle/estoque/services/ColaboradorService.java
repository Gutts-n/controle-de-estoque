package com.br.controle.estoque.services;

import com.br.controle.estoque.domain.model.Colaborador;
import com.br.controle.estoque.domain.repositories.ColaboradorRepository;
import com.br.controle.estoque.error.exceptions.ControleDeEstoqueException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    public Colaborador salvar(Colaborador colaborador){

        Optional<Colaborador> colaboradorOptional = buscarColaborador(colaborador);

        if (colaboradorOptional.isPresent()){
            throw new ControleDeEstoqueException("Colaborador já cadastrado!");
        }

        return colaboradorRepository.save(colaborador);
    }

    private Optional<Colaborador> buscarColaborador(Colaborador colaborador){
        return colaboradorRepository.findByNomeAndCargo(colaborador.getNome(), colaborador.getCargo());
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
