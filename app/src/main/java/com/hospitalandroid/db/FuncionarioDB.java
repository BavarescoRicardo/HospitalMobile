package com.hospitalandroid.db;

import com.hospitalandroid.modelo.Funcionario;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class FuncionarioDB extends BaseDaoImpl<Funcionario,Integer> {

    public FuncionarioDB(ConnectionSource cs) throws SQLException {
        super(Funcionario.class);
        setConnectionSource(cs);
        initialize();
    }

}
