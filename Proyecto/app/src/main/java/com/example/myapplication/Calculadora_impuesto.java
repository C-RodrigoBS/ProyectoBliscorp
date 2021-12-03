package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calculadora_impuesto extends AppCompatActivity {

    String NOMBRE_DIRECTORIO = "MisPDFs";
    String NOMBRE_DOCUMENTO = "MiPDF.pdf";

    EditText iptvalor_inmueble;
    EditText iptprecio_adquisicion;

    TextInputLayout tilvalor_inmueble;
    TextInputLayout tilprecio_adquisicion;

    CheckBox cbxprev_2004;
    CheckBox cbxunica_propiedad;
    CheckBox cbxocupada_mas2años;

    Button btncalcularIR;
    Button btnverarchivosIR;
    Button btnverarchivosIRlru;

    Bitmap bmp, scaledbmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_impuesto);

        btncalcularIR = findViewById(R.id.btncalcularIR);
        btnverarchivosIR = findViewById(R.id.btnverarchivosIR);
        btnverarchivosIRlru = findViewById(R.id.btnverarchivosIRlru);

        iptvalor_inmueble = findViewById(R.id.iptvalor_inmueble);
        iptprecio_adquisicion = findViewById(R.id.iptprecio_adquisicion);
        tilvalor_inmueble = findViewById(R.id.tilvalor_inmueble);
        tilprecio_adquisicion = findViewById(R.id.tilprecio_adquisicion);

        cbxprev_2004 = findViewById(R.id.cbxprev_2004);
        cbxunica_propiedad = findViewById(R.id.cbxunica_propiedad);
        cbxocupada_mas2años = findViewById(R.id.cbxocupada_mas2años);


        // Permisos
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                        PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,},
                    1000);
        }

        btncalcularIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validar_formulario();
            }
        });

        btnverarchivosIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Calculadora_impuesto.this, Listado.class));
            }
        });

        btnverarchivosIRlru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Calculadora_impuesto.this, Listado_lru.class));
            }
        });

    }
    private void obtener_calculo(){
        DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
        String date= df1.format(Calendar.getInstance().getTime());
        NOMBRE_DOCUMENTO = "" + ((int) (Math.random()*10000000)) + "&" + date+".pdf";

        double valor_inmueble = Double.parseDouble(iptvalor_inmueble.getText().toString());
        double precio_adquisicion = Double.parseDouble(iptprecio_adquisicion.getText().toString());
        double impuesto = (valor_inmueble - (precio_adquisicion * 1.00)) * 0.05;
        boolean[] datos = validar_cbx();
        crearPDF(impuesto, "No aplica","");
        Toast.makeText(Calculadora_impuesto.this, "SE CREO EL PDF", Toast.LENGTH_LONG).show();

        if (datos[0] || datos [1]){
            crearPDF(impuesto, "No aplica","");
            Toast.makeText(Calculadora_impuesto.this, "SE CREO EL PDF", Toast.LENGTH_LONG).show();
        }else{
            String datos_extra = "";
            if (!datos[0]){
                datos_extra += "\nLa propiedad debio estar inscrita antes del año 2004";
            }
            if (!datos[2]){
                datos_extra += "\nEsta debe ser su unica propiedad";
            }
            if (!datos[3]){
                datos_extra += "\nLa propiedad Debio haber estado ocupada por almenos dos años";
            }
            crearPDF(impuesto, "Si aplica", datos_extra);
            Toast.makeText(Calculadora_impuesto.this, "SE CREO EL PDF", Toast.LENGTH_LONG).show();
        }


    }


    private void validar_formulario(){
        if (!validar(iptvalor_inmueble, tilvalor_inmueble, "Debe ingresar el valor del inmueble")){
            return;
        }
        if (!validar(iptprecio_adquisicion, tilprecio_adquisicion, "Debe ingresar el valor de adquisicion")){
            return;
        }
        obtener_calculo();
    }


    private boolean validar(EditText editText, TextInputLayout textInputLayout, String error){
        if (editText.getText().toString().trim().isEmpty()){
            textInputLayout.setError(error);
            return false;
        }else{
            textInputLayout.setErrorEnabled(false);
        }

        return true;
    }

    private boolean[] validar_cbx(){
        boolean[] respuestas = new boolean[4];
        if (cbxprev_2004.isChecked()){
            respuestas[0] = true;
        }else{
            respuestas[0] = false;
        }
        if(cbxunica_propiedad.isChecked()){
            respuestas[2] = true;
            if(cbxocupada_mas2años.isChecked()){
                respuestas[1] = true;
            }else{
                respuestas[1] = false;
            }
        }else{
            respuestas[1] = false;
            respuestas[2] = false;
        }
        if(cbxocupada_mas2años.isChecked()){
            respuestas[3] = true;
        }else{
            respuestas[3] = false;
        }
        return respuestas;
    }

    public void crearPDF(double impuesto, String aplica, String no_aplica) {
        Document documento = new Document();




        try {
            File file = crearFichero(NOMBRE_DOCUMENTO);
            FileOutputStream ficheroPDF = new FileOutputStream(file.getAbsolutePath());

            PdfWriter writer = PdfWriter.getInstance(documento, ficheroPDF);

            documento.open();
            /*
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.header);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            Image imagen = Image.getInstance(stream.toByteArray());
            imagen.scaleToFit(150, 150);
            documento.add(imagen);
            */
            documento.add(new Paragraph("TABLA \n\n"));
            //documento.add(new Paragraph( etTexto.getText().toString()+"\n\n"));

            // Insertamos una tabla
            PdfPTable tabla = new PdfPTable(2);
            tabla.addCell("Tipo de dato");
            tabla.addCell("Descripcion");
            tabla.addCell("Impuesto a la renta");
            tabla.addCell(String.valueOf(impuesto));
            tabla.addCell("¿El impuesto aplica?");
            tabla.addCell(aplica);
            tabla.addCell("Detalles para no aplicar al impuesto");
            tabla.addCell(no_aplica);

            documento.add(tabla);

        } catch(DocumentException e) {
        } catch(IOException e) {
        } finally {
            documento.close();
            Toast.makeText(Calculadora_impuesto.this, "SE CREO EL PDF", Toast.LENGTH_LONG).show();
        }
    }

    public File crearFichero(String nombreFichero) {
        File ruta = getRuta();

        File fichero = null;
        if(ruta != null) {
            fichero = new File(ruta, nombreFichero);
        }

        return fichero;
    }

    public File getRuta() {
        File ruta = null;

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            ruta = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), NOMBRE_DIRECTORIO);

            if (ruta != null) {
                if (!ruta.mkdirs()) {
                    if (!ruta.exists()) {
                        return null;
                    }
                }
            }

        }
        return ruta;
    }
    public void aaa(){
        File dir = Environment.getExternalStorageDirectory();
        String path = dir.getAbsolutePath();

        File carpeta = new File(path);
        String[] listado = carpeta.list();
        if (listado == null || listado.length == 0) {
            Toast.makeText(this, "No hay elementos dentro de la carpeta actual", Toast.LENGTH_SHORT).show();
            System.out.println("No hay elementos dentro de la carpeta actual");
            return;
        }else {
            for (int i=0; i< listado.length; i++) {
                System.out.println(listado[i]);
            }
        }
    }
}