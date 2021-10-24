package com.br.controle.estoque.domain.repositories;

import com.br.controle.estoque.domain.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    @Query("SELECT c FROM Cargo c WHERE UPPER(c.nome) = UPPER(:nome)")
    Optional<Cargo> findByNome(String nome);

}
