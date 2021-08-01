package com.br.controle.estoque.repositories;

import com.br.controle.estoque.model.EstatitisticaDiariaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EstatitisticaDiariaProdutoRepository extends JpaRepository<EstatitisticaDiariaProduto, LocalDate> {

}
