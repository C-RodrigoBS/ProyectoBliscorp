package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Generador_de_contratos extends AppCompatActivity {


    Spinner combo;
    Button btnsig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generador_de_contratos);

        combo = (Spinner) findViewById(R.id.cbxprop);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.arrcbx, android.R.layout.simple_spinner_item);
        combo.setAdapter(adapter);

        btnsig = (Button) findViewById(R.id.btnsig);
        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Generador_de_contratos.this, Generador_de_contratos2.class));
            }
        });

    }

}