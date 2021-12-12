package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Datos_inmueble extends AppCompatActivity {
    private Spinner inmueble;
    private Spinner departamento;
    private Spinner provincia;
    private Spinner distrito;
    private Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_inmueble);
        inmueble = (Spinner) findViewById(R.id.inmueble);
        departamento =(Spinner) findViewById(R.id.departamento);
        provincia = (Spinner) findViewById(R.id.provincia);
        distrito = (Spinner) findViewById(R.id.distrito);
        siguiente = (Button) findViewById(R.id.siguiente);

        String []opciones = {"departamento", "casa", "terreno"};
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        inmueble.setAdapter(adapter);
    }
}