package com.br.controle.estoque.repositories;

import com.br.controle.estoque.model.Cargo;
import com.br.controle.estoque.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    Optional<Colaborador> findByNomeAndCargo(String nome, Cargo cargo);

}
