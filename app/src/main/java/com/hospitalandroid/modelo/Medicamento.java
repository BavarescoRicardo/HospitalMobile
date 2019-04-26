package com.hospital.model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ricardo
 */
public class Medicamento {
    private String nome;
    private int idMedicamento;

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
