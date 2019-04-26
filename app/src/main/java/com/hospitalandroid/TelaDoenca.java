package com.hospitalandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.hospitalandroid.db.DatabaseHelper;
import com.hospitalandroid.db.DoencaDB;
import com.hospitalandroid.modelo.Doenca;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelaDoenca extends AppCompatActivity {

    private Button btnVoltar,btnInserir;
    private EditText txtDoenca;
    private ListView tabela;
    private DatabaseHelper dh;
    private DoencaDB db;
    private List<Doenca> lista;
    private ArrayAdapter<Doenca> doencaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_doenca);

        dh = new DatabaseHelper(TelaDoenca.this);

        txtDoenca = (EditText) findViewById(R.id.txtDoenca);
        tabela = (ListView) findViewById(R.id.tabelaDoenca);


        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });


        btnInserir = (Button) findViewById(R.id.btnInserirDoen);
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inclusao();

            }
        });

        listar();

    }


    private void listar(){
        lista = new ArrayList<Doenca>();

        try {
            db = new DoencaDB(dh.getConnectionSource());
            lista = db.queryForAll();
            doencaAdapter = new ArrayAdapter<Doenca>(TelaDoenca.this,android.R.layout.simple_list_item_1,lista);
            /*
            for (Doenca d : lista){
                Toast.makeText(TelaDoenca.this,"Doenca  "+d.getNome(),Toast.LENGTH_LONG).show();
            }
            */
            tabela.setAdapter(doencaAdapter);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    private void inclusao(){
        Doenca doenca = new Doenca(txtDoenca.getText().toString());
        try {
            db = new DoencaDB(dh.getConnectionSource());
            // incluir no bd
            db.create(doenca);
            txtDoenca.setText("");
            Log.i("Script","Doenca inluida");
            Toast.makeText(TelaDoenca.this,"Sucesso",Toast.LENGTH_SHORT).show();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
