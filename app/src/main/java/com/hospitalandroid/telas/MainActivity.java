package com.hospitalandroid.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hospitalandroid.R;

public class MainActivity extends AppCompatActivity {

    private Button btnDoenca,btnMedicamento,btnFuncionario,btnCargo;
    private Intent intencao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDoenca = (Button) findViewById(R.id.btnDoen);
        btnDoenca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 intencao = new Intent(getApplicationContext(),TelaDoenca.class);
                 startActivity(intencao);
            }
        });

        btnMedicamento = (Button) findViewById(R.id.btnMedicamento);
        btnMedicamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intencao = new Intent(getApplicationContext(),TelaMedicamento.class);
                startActivity(intencao);
            }
        });

        btnCargo = (Button) findViewById(R.id.btnFuncao);
        btnCargo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intencao = new Intent(getApplicationContext(),TelaFuncao.class);
                startActivity(intencao);
            }
        });

        btnFuncionario = (Button) findViewById(R.id.btnFuncionario);
        btnFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intencao = new Intent(getApplicationContext(),TelaFuncionario.class);
                startActivity(intencao);
            }
        });

    }

}
