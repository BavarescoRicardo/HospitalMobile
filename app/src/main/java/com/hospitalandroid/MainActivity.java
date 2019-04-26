package com.hospitalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

    }
}
