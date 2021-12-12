package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
public class Menu_inicial extends AppCompatActivity {

    Button btncontratos;
    Button btncalimp;
<<<<<<< HEAD
    Button btnval;
    Button btntram;
=======
    Button btnSimuladorContra;
>>>>>>> 5254b7ffa43070c3947482c2169a941e4027509e

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);

        btncontratos = (Button) findViewById(R.id.btncontratos);
        btncalimp = (Button) findViewById(R.id.btncalimp);
<<<<<<< HEAD
        btnval = (Button) findViewById(R.id.btnvalcom);
        btntram = (Button) findViewById(R.id.btntramun);
=======
        btnSimuladorContra = (Button) findViewById(R.id.btnsimcred);
>>>>>>> 5254b7ffa43070c3947482c2169a941e4027509e


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

<<<<<<< HEAD
        btnval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_inicial.this, Valorizacion_comercial.class));
            }

        });

        btntram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu_inicial.this, Tramites_municipales.class));
=======
        btnSimuladorContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu_inicial.this, simulador_creditos.class));
>>>>>>> 5254b7ffa43070c3947482c2169a941e4027509e
            }
        });

    }
}