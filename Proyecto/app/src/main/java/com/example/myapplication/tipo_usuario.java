package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tipo_usuario extends AppCompatActivity {
    ImageButton broker;
    ImageButton blis;
    ImageButton externo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_usuario);
        broker=(ImageButton)findViewById(R.id.broker);
        blis=(ImageButton)findViewById(R.id.agente_blis);
        externo=(ImageButton)findViewById(R.id.externo);

        broker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tipo_usuario.this, Login.class));
            }
        });

        blis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tipo_usuario.this, Login.class));
            }
        });

        externo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tipo_usuario.this, Login.class));
            }
        });
    }
}