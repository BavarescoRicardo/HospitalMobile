package com.hospitalandroid.db;

import com.hospitalandroid.modelo.Doenca;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class DoencaDB extends BaseDaoImpl<Doenca,Integer> {

    public DoencaDB(ConnectionSource cs) throws SQLException {
        super(Doenca.class);
        setConnectionSource(cs);
        initialize();
    }

}
