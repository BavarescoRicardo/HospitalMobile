package com.hospitalandroid.modelo;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Ricardo
 */
@DatabaseTable(tableName="Doenca")
public class Doenca {
    @DatabaseField(generatedId = true)
    private int idDoenca;
    @DatabaseField
    private String nome;

    public Doenca() {
    }

    public Doenca(String nome) {
        this.nome = nome;
    }

    public int getIdDoenca() {
        return idDoenca;
    }

    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Doenca " + " " + nome + "\n";
    }
    
    
}
