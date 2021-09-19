package com.br.controle.estoque.domain.repositories;

import com.br.controle.estoque.domain.model.EstatitisticaDiariaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EstatitisticaDiariaProdutoRepository extends JpaRepository<EstatitisticaDiariaProduto, LocalDate> {

}
