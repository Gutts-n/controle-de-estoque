package com.br.controle.estoque.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "colaboradores")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Estabelecimento estabelecimento;

    private String nome;

    private String login;

    private String senha;

    @OneToOne
    private Cargo cargo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colaborador that = (Colaborador) o;
        return Objects.equals(id, that.id) && Objects.equals(estabelecimento, that.estabelecimento) && Objects.equals(nome, that.nome) && Objects.equals(login, that.login) && Objects.equals(senha, that.senha) && Objects.equals(cargo, that.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estabelecimento, nome, login, senha, cargo);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Colaborador() {
    }

    public Colaborador(String nome, Cargo cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }
}
