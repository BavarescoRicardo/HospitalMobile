package com.hospitalandroid.db;

import com.hospitalandroid.modelo.Medicamento;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class MedicamentoDB extends BaseDaoImpl<Medicamento,Integer> {

    public MedicamentoDB(ConnectionSource cs) throws SQLException {
        super(Medicamento.class);
        setConnectionSource(cs);
        initialize();
    }

}
