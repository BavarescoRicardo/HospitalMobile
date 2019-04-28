package com.hospitalandroid.db;

import com.hospitalandroid.modelo.TipoFuncionario;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class TipoFuncionarioDB extends BaseDaoImpl<TipoFuncionario,Integer> {

    public TipoFuncionarioDB(ConnectionSource cs) throws SQLException {
        super(TipoFuncionario.class);
        setConnectionSource(cs);
        initialize();
    }

}
