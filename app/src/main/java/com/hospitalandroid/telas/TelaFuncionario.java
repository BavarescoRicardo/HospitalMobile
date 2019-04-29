package com.hospitalandroid.telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hospitalandroid.R;

public class TelaFuncionario extends AppCompatActivity {

    private Button btnVoltar,btnInserir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_funcionario);

        btnVoltar = (Button) findViewById(R.id.btnVoltarFuncionario);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}
