/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.model;

/**
 *
 * @author Ricardo
 */
public class TipoFuncionario {
    private int idTipoFuncionario;
    private String descricao;

    public int getIdTipoFuncionario() {
        return idTipoFuncionario;
    }

    public void setIdTipoFuncionario(int idTipoFuncionario) {
        this.idTipoFuncionario = idTipoFuncionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoFuncionario() {
    }

    public TipoFuncionario(String descricao) {
        this.descricao = descricao;
    }

    public TipoFuncionario(int idTipoFuncionario, String descricao) {
        this.idTipoFuncionario = idTipoFuncionario;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return idTipoFuncionario + " Cargo " + descricao;
    }
    
    
}
