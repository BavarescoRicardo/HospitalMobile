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
@DatabaseTable(tableName="Medicamento")
public class Medicamento {
    @DatabaseField(generatedId = true)
    private int idMedicamento;
    @DatabaseField
    private String nome;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Medicamento() {
    }

    public Medicamento(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Medicamento " + " " + nome + "\n";
    }
    
    
}
