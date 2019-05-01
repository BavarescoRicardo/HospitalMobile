package com.hospitalandroid.telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.hospitalandroid.R;
import com.hospitalandroid.db.DatabaseHelper;
import com.hospitalandroid.db.FuncionarioDB;
import com.hospitalandroid.modelo.Funcionario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelaListaFuncionario extends AppCompatActivity {

    private DatabaseHelper dh;
    private ListView tabela;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_funcionario);
        dh = new DatabaseHelper(TelaListaFuncionario.this);

        tabela = (ListView) findViewById(R.id.listaFuncionario);

        btnVoltar  = (Button) findViewById(R.id.btnVoltarListaFn);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        listar();

    }

    private void listar(){
        List<Funcionario> lista = new ArrayList<Funcionario>();
        ArrayAdapter<Funcionario> adaptador;

        try {
            FuncionarioDB  db = new FuncionarioDB(dh.getConnectionSource());
            lista = db.queryForAll();
            adaptador = new ArrayAdapter<Funcionario>(TelaListaFuncionario.this,android.R.layout.simple_list_item_1,lista);

            tabela.setAdapter(adaptador);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
