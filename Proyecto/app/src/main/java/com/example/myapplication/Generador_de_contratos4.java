package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
public class Generador_de_contratos4 extends AppCompatActivity {

    Spinner combo;
    Spinner combo2;
    Spinner combo3;
    Spinner combo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generador_de_contratos4);

        combo = (Spinner) findViewById(R.id.cbxtipdoc);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.arrcbxtipdoc, android.R.layout.simple_spinner_item);
        combo.setAdapter(adapter);

        combo2 = (Spinner) findViewById(R.id.cbxmes);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.arrcbxper, android.R.layout.simple_spinner_item);
        combo2.setAdapter(adapter2);

        combo3 = (Spinner) findViewById(R.id.cbxdiv);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.arrcbxdiv, android.R.layout.simple_spinner_item);
        combo3.setAdapter(adapter3);

        combo4 = (Spinner) findViewById(R.id.cbxdiv2);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.arrcbxdiv, android.R.layout.simple_spinner_item);
        combo4.setAdapter(adapter4);
    }
}