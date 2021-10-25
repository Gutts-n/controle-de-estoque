package com.br.controle.estoque.domain.dto;

import com.br.controle.estoque.domain.model.Cargo;
import com.br.controle.estoque.domain.model.Colaborador;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
public class ColaboradorDTO {

    @NotBlank
    @Size(max = 200)
    private String nome;

    @NotNull
    private Long idEstab;

    @NotNull
    private Long idCargo;

    public ColaboradorDTO(String nome, Long idCargo, Long idEstab) {
        this.nome = nome;
        this.idCargo = idCargo;
        this.idEstab = idEstab;
    }

    public Colaborador toColaborador(){
        return new Colaborador(nome, new Cargo(idCargo));
    }

    public Long getIdEstab() {
        return idEstab;
    }

    public void setIdEstab(Long idEstab) {
        this.idEstab = idEstab;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
