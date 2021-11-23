package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
public class Generador_de_contratos3 extends AppCompatActivity {

    Spinner combo;
    Spinner combo2;
    Spinner combo3;
    Spinner combo4;
    Button btnsig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generador_de_contratos3);

        combo = (Spinner) findViewById(R.id.cbxtipinm);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.arrcbxtipinm, android.R.layout.simple_spinner_item);
        combo.setAdapter(adapter);

        combo2 = (Spinner) findViewById(R.id.cbxdepinm);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.arrcbxdep, android.R.layout.simple_spinner_item);
        combo2.setAdapter(adapter2);

        combo3 = (Spinner) findViewById(R.id.cbxproinm);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.arrcbxpro, android.R.layout.simple_spinner_item);
        combo3.setAdapter(adapter3);

        combo4 = (Spinner) findViewById(R.id.cbxdisinm);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.arrcbxdis, android.R.layout.simple_spinner_item);
        combo4.setAdapter(adapter4);

        btnsig = (Button) findViewById(R.id.btnsig3);
        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Generador_de_contratos3.this, Generador_de_contratos4.class));
            }
        });
    }
}