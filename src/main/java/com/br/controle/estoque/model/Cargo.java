package com.br.controle.estoque.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cargos")
@Data
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

}
