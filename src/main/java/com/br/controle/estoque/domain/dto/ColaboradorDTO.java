package com.br.controle.estoque.domain.dto;

import com.br.controle.estoque.domain.model.Cargo;
import com.br.controle.estoque.domain.model.Colaborador;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
public class ColaboradorDTO {

    @NotBlank
    @Size(max = 200)
    private String nome;

    @NotBlank
    @Size(max = 250)
    private String cargo;

    @NotBlank
    @Size(max = 30, min = 7)
    private String senha;

    public Colaborador toColaborador(){
        return new Colaborador(nome, new Cargo(cargo));
    }

    public ColaboradorDTO(String nome, String cargo, String senha) {
        this.nome = nome;
        this.cargo = cargo;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
