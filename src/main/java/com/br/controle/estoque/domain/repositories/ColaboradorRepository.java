package com.br.controle.estoque.domain.repositories;

import com.br.controle.estoque.domain.model.Cargo;
import com.br.controle.estoque.domain.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    Optional<Colaborador> findByNomeAndCargo(String nome, Cargo cargo);

}
