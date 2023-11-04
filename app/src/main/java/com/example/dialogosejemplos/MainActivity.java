package com.example.dialogosejemplos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/*
Autor: Juan Francisco Sánchez González
Fecha: 01/11/2023
Clase: Actividad principal dónde se infla un OptionsMenu (Con 2 elementos, salir de la aplicación y
cambiar de actividad). También tiene un botón que al pulsarlo se muestra un cuadro de diálogo para cambiar
de actividad con dos botones (Aceptar y Cancelar).
*/

public class MainActivity extends AppCompatActivity {

    private Button btnDialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cuadro de diálogo con 2 botones
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.mens_cuadro1))
                .setTitle(getResources().getString(R.string.tit_cuadro1))
                .setIcon(R.drawable.ic_launcher_background)
                .setPositiveButton(getResources().getString(R.string.btnpos_cuadro1), new DialogInterface.OnClickListener() {
                    // Escuchador botón positivo
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Cambio a la Actividad 2
                        Intent cambiarActividad;
                        cambiarActividad = new Intent(getApplicationContext(), Actividad2.class);
                        startActivity(cambiarActividad);
                    }
                })
                .setNegativeButton(getResources().getString(R.string.btnneg_cuadro1), new DialogInterface.OnClickListener() {
                    // Escuchador botón negativo
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        AlertDialog dialogo = builder.create();
        // Botón que muestra el cuadro de diálogo
        btnDialogo = (Button) findViewById(R.id.button);
        btnDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.show();
            }
        });
    }

    // Método para inflar el OptionsMenu del recurso opciones_act1.xml en la Actividad
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opciones_act1, menu);
        return true;
    }

    // Listener del OptionsMenu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent cambiarActividad;
        cambiarActividad = new Intent(this, Actividad2.class);
        int id = item.getItemId();
        if (id == R.id.Salir){
            // Salir de la aplicación
            finishAndRemoveTask();
        } else {
            // Cambio a la Actividad 2
            startActivity(cambiarActividad);
        }
        return super.onOptionsItemSelected(item);
    }
}