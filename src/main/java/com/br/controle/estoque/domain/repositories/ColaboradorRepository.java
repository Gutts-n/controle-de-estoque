package com.br.controle.estoque.domain.repositories;

import com.br.controle.estoque.domain.model.Cargo;
import com.br.controle.estoque.domain.model.Colaborador;
import com.br.controle.estoque.domain.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    @Query("SELECT c FROM Colaborador c WHERE " +
            "UPPER(c.nome) = UPPER(:nome) " +
            "AND c.cargo = :cargo " +
            "AND c.estabelecimento = :estab")
    Optional<Colaborador> findByNomeCargoAndEstab(String nome, Cargo cargo, Estabelecimento estab);

}
