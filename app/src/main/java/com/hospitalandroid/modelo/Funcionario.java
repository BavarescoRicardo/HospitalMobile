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
@DatabaseTable(tableName="Funcionario")
public class Funcionario {
    @DatabaseField(generatedId = true)
    private int idFuncionario;
    @DatabaseField(foreign = true)
    private TipoFuncionario tipoFuncionario;
    @DatabaseField
    private String NOME,CPF,EMAIL,CONTATO;
    @DatabaseField
    private String dataNascimento;

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCONTATO() {
        return CONTATO;
    }

    public void setCONTATO(String CONTATO) {
        this.CONTATO = CONTATO;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Funcionario() {
    }

    public Funcionario(TipoFuncionario tipoFuncionario, String NOME, String CPF, String EMAIL, String dataNascimento) {
        this.tipoFuncionario = tipoFuncionario;
        this.NOME = NOME;
        this.CPF = CPF;
        this.EMAIL = EMAIL;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "NOME = " + NOME +
                "\n CPF= " + CPF +
                "\n EMAIL = " + EMAIL +
                "\n Nascimento = " + dataNascimento;
    }
}
