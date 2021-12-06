package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class reporte_impuestos extends AppCompatActivity {

    TextView txt_campo;
    TextView txt_valor;
    TextView txt_impuesto;
    TextView txt_impuesto_valor;
    TextView txt_sin_impuesto;
    TextView txt_sin_impuesto_valor;
    TextView txt_con_impuesto;
    TextView txt_con_impuesto_valor;
    TextView txt_aplica;
    TextView txt_aplica_valor;
    TextView txt_detalles;
    TextView txt_detalles_valor;

    Button btnregresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_impuestos);
        String impuesto = getIntent().getStringExtra("impuesto");
        String aplica = getIntent().getStringExtra("aplica");
        String datos_extra = getIntent().getStringExtra("datos_extra");

        txt_campo = findViewById(R.id.txt_campo);
        txt_valor = findViewById(R.id.txt_valor);
        txt_impuesto = findViewById(R.id.txt_impuesto);
        txt_impuesto_valor = findViewById(R.id.txt_impuesto_valor);
        txt_sin_impuesto = findViewById(R.id.txt_sin_impuesto);
        txt_sin_impuesto_valor = findViewById(R.id.txt_sin_impuesto_valor);
        txt_con_impuesto = findViewById(R.id.txt_con_impuesto);
        txt_con_impuesto_valor = findViewById(R.id.txt_con_impuesto_valor);
        txt_aplica = findViewById(R.id.txt_aplica);
        txt_aplica_valor = findViewById(R.id.txt_aplica_valor);
        txt_detalles = findViewById(R.id.txt_detalles);
        txt_detalles_valor = findViewById(R.id.txt_detalles_valor);

        btnregresar = findViewById(R.id.btnregresar);

        Double sin_impuesto = Double.valueOf(impuesto) * 20;
        Double con_impuesto = Double.valueOf(impuesto) * 19;

        txt_campo.setText("Tipo de dato");
        txt_valor.setText("Valor");
        txt_impuesto.setText("Impuesto:");
        txt_impuesto_valor.setText(impuesto);
        txt_sin_impuesto.setText("Ganancial sin impuesto:");
        txt_sin_impuesto_valor.setText(String.valueOf(sin_impuesto));
        txt_con_impuesto.setText("Ganancial con impuesto:");
        txt_con_impuesto_valor.setText(String.valueOf(con_impuesto));
        txt_aplica.setText("¿El impuesto aplica?");
        txt_aplica_valor.setText(aplica);
        txt_detalles.setText("Condiciones para no aplicar:");
        txt_detalles_valor.setText(datos_extra);

        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(reporte_impuestos.this, Calculadora_impuesto.class));
            }
        });
    }
}