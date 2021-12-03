package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Listado extends AppCompatActivity {

    private List<String> item = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        // Permisos
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                        PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,},
                    1000);
        }

        item = new ArrayList<String>();

        File f = new File(Environment.getExternalStorageDirectory() + "/MisPDFs/");
        File[] files = f.listFiles();

        for (int i = 0; i < files.length; i++)

        {
            File file = files[i];

            if (file.isDirectory())

                item.add(file.getName() + "/");

            else

                item.add(file.getName());
        }


        //Mostramos la ruta en el layout
        TextView ruta = (TextView) findViewById(R.id.ruta);
        ruta.setText(Environment.getExternalStorageDirectory() + "/MisPDFs/");

        //Localizamos y llenamos la lista
        ListView lstOpciones = (ListView) findViewById(R.id.listaFiles);
        ArrayAdapter<String> fileList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
        lstOpciones.setAdapter(fileList);

        // Accion para realizar al pulsar sobre la lista
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                // Devuelvo los datos a la activity principal
                Intent data = new Intent();
                data.putExtra("filename", item.get(position));
                setResult(RESULT_OK, data);
                finish();

            }
        });
    }
}