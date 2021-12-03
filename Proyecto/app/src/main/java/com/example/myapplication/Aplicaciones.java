package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Aplicaciones extends AppCompatActivity {
    Button contratos;
    Button impuestos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicaciones);
        contratos = (Button)findViewById(R.id.contratos);
        impuestos = (Button)findViewById(R.id.impuestos);

        contratos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aplicaciones.this, Datos_inmueble.class));
            }

        });
        impuestos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Aplicaciones.this, Calculadora_impuesto.class));
            }
        });
    }

}