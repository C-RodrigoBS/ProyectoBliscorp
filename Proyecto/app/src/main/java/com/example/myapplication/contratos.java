package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class contratos extends AppCompatActivity {

    Button btnventexc;
    Button btnventnoexc;
    Button btnalqexc;
    Button btnalqnoexc;
    Button btnantexc;
    Button btnantnoexc;
    Button btnreserven;
    Button btnreseralq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contratos2);

        btnventexc = (Button) findViewById(R.id.btnventexc);
        btnventexc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contratos.this, Generador_de_contratos.class));
            }
        });

        btnventnoexc = (Button) findViewById(R.id.btnventnoexc);
        btnventnoexc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contratos.this, Generador_de_contratos.class));
            }
        });

        btnalqexc = (Button) findViewById(R.id.btnalqexc);
        btnalqexc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contratos.this, Generador_de_contratos.class));
            }
        });

        btnalqnoexc = (Button) findViewById(R.id.btnalqnoexc);
        btnalqnoexc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contratos.this, Generador_de_contratos.class));
            }
        });

        btnantexc = (Button) findViewById(R.id.btnantexc);
        btnantexc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contratos.this, Generador_de_contratos.class));
            }
        });

        btnantnoexc = (Button) findViewById(R.id.btnantnoexc);
        btnantnoexc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contratos.this, Generador_de_contratos.class));
            }
        });

        btnreserven = (Button) findViewById(R.id.btnreserven);
        btnreserven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contratos.this, Generador_de_contratos.class));
            }
        });

        btnreseralq = (Button) findViewById(R.id.btnreseralq);
        btnreseralq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(contratos.this, Generador_de_contratos.class));
            }
        });
    }
}