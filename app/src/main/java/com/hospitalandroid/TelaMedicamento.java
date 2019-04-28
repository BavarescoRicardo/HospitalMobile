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

import com.hospitalandroid.modelo.Medicamento;

import com.hospitalandroid.db.DatabaseHelper;
import com.hospitalandroid.db.MedicamentoDB;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelaMedicamento extends AppCompatActivity {

    private Button btnVoltar,btnInserir;
    private EditText txtMedicamento;
    private ListView tabela;
    private DatabaseHelper dh;
    private ArrayAdapter<Medicamento> medicamentoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_medicamento);

        tabela = (ListView) findViewById(R.id.tabelaMedicamentos);
        dh = new DatabaseHelper(TelaMedicamento.this);
        txtMedicamento = (EditText) findViewById(R.id.txtNomeMedicamento);

        btnVoltar = (Button) findViewById(R.id.btnVoltarMed);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        btnInserir = (Button) findViewById(R.id.btnInserirMed);
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incluir();
            }
        });

        listar();

    }

    private void listar(){
        List<Medicamento> listaM = new ArrayList<Medicamento>();

        try {
            MedicamentoDB db = new MedicamentoDB(dh.getConnectionSource());

            db = new MedicamentoDB(dh.getConnectionSource());
            listaM = db.queryForAll();
            medicamentoAdapter = new ArrayAdapter<Medicamento>(TelaMedicamento.this,android.R.layout.simple_list_item_1,listaM);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        tabela.setAdapter(medicamentoAdapter);
    }

    private void incluir(){
        Medicamento medicamento = new Medicamento(txtMedicamento.getText().toString());

        try {
            Log.i("Script","tentativa 1");
            MedicamentoDB dbMed = new MedicamentoDB(dh.getConnectionSource());
            Log.i("Script","tentativa 2");
            dbMed.create(medicamento);
            txtMedicamento.setText("");
            Log.i("Script","Medicamento inluido");
            Toast.makeText(TelaMedicamento.this,"Sucesso",Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
