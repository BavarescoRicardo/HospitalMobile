package com.hospitalandroid.telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.hospitalandroid.R;
import com.hospitalandroid.db.DatabaseHelper;
import com.hospitalandroid.db.TipoFuncionarioDB;
import com.hospitalandroid.modelo.TipoFuncionario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelaFuncao extends AppCompatActivity {

    private Button btnVoltar,btnInserir;
    private EditText txtFuncao;
    private ListView tabela;
    private List<TipoFuncionario> lista;
    private ArrayAdapter<TipoFuncionario> tipoAdaptador;
    private DatabaseHelper dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_funcao);

        dh = new DatabaseHelper(TelaFuncao.this);
        txtFuncao = (EditText) findViewById(R.id.txtNomeCargo);
        tabela = (ListView) findViewById(R.id.tabelaCargos);

        btnVoltar = (Button) findViewById(R.id.btnVoltarCargo);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        btnInserir = (Button) findViewById(R.id.btnInserirCargo);
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incluir();
            }
        });

        listar();
    }

    private void listar(){
        lista = new ArrayList<TipoFuncionario>();

        try {
            TipoFuncionarioDB  dbTipo = new TipoFuncionarioDB(dh.getConnectionSource());
            lista = dbTipo.queryForAll();
            tipoAdaptador = new ArrayAdapter<TipoFuncionario>(TelaFuncao.this,android.R.layout.simple_list_item_1,lista);

            tabela.setAdapter(tipoAdaptador);

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    private void incluir(){
        TipoFuncionario tipo = new TipoFuncionario(txtFuncao.getText().toString());

        try {
            TipoFuncionarioDB tipoDB = new TipoFuncionarioDB(dh.getConnectionSource());
            tipoDB.create(tipo);
            txtFuncao.setText("");
            Toast.makeText(TelaFuncao.this,"Adiciounado com sucesso", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
