package com.hospital.model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricardo
 */
public class Medico {
    private int idMedico;
    private String NOME,CRM,CPF,ESPECIALIDADE,EMAIL;
    //private java.sql.Date dataNascimento;

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getESPECIALIDADE() {
        return ESPECIALIDADE;
    }

    public void setESPECIALIDADE(String ESPECIALIDADE) {
        this.ESPECIALIDADE = ESPECIALIDADE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public Medico(String NOME, String CRM, String CPF, String ESPECIALIDADE, String EMAIL) {
        this.NOME = NOME;
        this.CRM = CRM;
        this.CPF = CPF;
        this.ESPECIALIDADE = ESPECIALIDADE;
        this.EMAIL = EMAIL;
    }

    public Medico() {
    }

    @Override
    public String toString() {
        return "Medico  " + NOME + ", CRM = " + CRM + ", CPF = " + CPF + ", ESPECIALIDADE = " + ESPECIALIDADE + ", EMAIL = " + EMAIL + '}';
    }
    
    
    
}
