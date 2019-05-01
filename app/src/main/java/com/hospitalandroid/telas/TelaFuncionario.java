package com.hospitalandroid.telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.hospitalandroid.R;
import com.hospitalandroid.db.DatabaseHelper;
import com.hospitalandroid.db.FuncionarioDB;
import com.hospitalandroid.db.TipoFuncionarioDB;
import com.hospitalandroid.modelo.Funcionario;
import com.hospitalandroid.modelo.TipoFuncionario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelaFuncionario extends AppCompatActivity {

    private Button btnVoltar,btnInserir;
    private EditText txtNome,txtEmail,txtCpf;
    private String nasc;
    private Spinner comboFuncao;
    private CalendarView dataN;
    private DatabaseHelper dh;
    private ArrayAdapter<TipoFuncionario> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_funcionario);

        dh = new DatabaseHelper(TelaFuncionario.this);
        txtNome = (EditText) findViewById(R.id.txtNomeFuncionario);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtCpf = (EditText) findViewById(R.id.txtCpf);
        carregaCombo();

        dataN = (CalendarView) findViewById(R.id.dataNasc);

        btnVoltar = (Button) findViewById(R.id.btnVoltarFuncionario);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });


        btnInserir = (Button) findViewById(R.id.btnInserirFuncionario);
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserir();
            }
        });
    }

    private void inserir(){
        TipoFuncionario tf = (TipoFuncionario) comboFuncao.getSelectedItem();
        java.sql.Date dataSq = new java.sql.Date(dataN.getDate());
        Funcionario funcionario = new Funcionario(tf,txtNome.getText().toString(),txtCpf.getText().toString(),txtEmail.getText().toString(),dataSq.toString());

        try {
            FuncionarioDB funcionarioBD = new FuncionarioDB(dh.getConnectionSource());
            funcionarioBD.create(funcionario);

            Toast.makeText(TelaFuncionario.this,"Funcionario inserido",Toast.LENGTH_LONG);
            txtNome.setText("");
            txtEmail.setText("");
            txtCpf.setText("");
            comboFuncao.setSelected(false);
            System.out.println("A data escolhida foi  "+dataSq.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void carregaCombo(){
        comboFuncao= (Spinner) findViewById(R.id.comboFuncao);
        List<TipoFuncionario> listaF = new ArrayList<TipoFuncionario>();

        //Inicia combo com valores do bd
        try {
            TipoFuncionarioDB db = new TipoFuncionarioDB(dh.getConnectionSource());

            listaF = db.queryForAll();
            adaptador = new ArrayAdapter(TelaFuncionario.this,android.R.layout.simple_list_item_1,listaF);
            comboFuncao.setAdapter(adaptador);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
