package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    Button registrarse;
    Button btnAgente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnAgente = (Button)findViewById(R.id.buttonAgente);
        //registrarse=(Button)findViewById(R.id.buttonRegistrarse);

        btnAgente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Menu_inicial.class));
            }

        });
        /*
        registrarse.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                              registrar(view);
                                           }
                                       }
        );*/

    }
    public void registrar(View view){
        Intent intent = new Intent(this,registro_usua.class);
        startActivity(intent);

    }


}