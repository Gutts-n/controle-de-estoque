package com.br.controle.estoque.para.edu.repositories;

import com.br.controle.estoque.para.edu.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
