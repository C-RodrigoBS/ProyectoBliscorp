package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_inicial extends AppCompatActivity {

    Button btncontratos;
    Button btncalimp;
    Button btnSimuladorContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);

        btncontratos = (Button) findViewById(R.id.btncontratos);
        btncalimp = (Button) findViewById(R.id.btncalimp);
        btnSimuladorContra = (Button) findViewById(R.id.btnsimcred);


        /*btncontratos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_inicial.this, contratos.class));
            }

        });*/
        btncalimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_inicial.this, Calculadora_impuesto.class));
            }
        });

        btnSimuladorContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu_inicial.this, simulador_creditos.class));
            }
        });

    }
}