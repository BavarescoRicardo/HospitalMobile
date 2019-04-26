package com.hospitalandroid.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.hospitalandroid.modelo.*;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String databaseName = "hospital.db";
    private static final int databaseVersion = 12;



    public DatabaseHelper(Context context, String databaseName, int databaseVersion) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource cs) {
        try {
            TableUtils.createTable(cs, Doenca.class);
            TableUtils.createTable(cs, Funcionario.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource cs, int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(cs, Doenca.class,true);
            TableUtils.dropTable(cs, Funcionario.class,true);
            onCreate(sqLiteDatabase,cs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close(){
        super.close();
    }
}
