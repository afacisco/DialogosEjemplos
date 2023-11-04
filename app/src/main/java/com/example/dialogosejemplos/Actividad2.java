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
import android.widget.Toast;

/*
Autor: Juan Francisco Sánchez González
Fecha: 01/11/2023
Clase: Segunda actividad dónde se infla un OptionsMenu (Con 1 elemento para cambiar de actividad).
También tiene un botón que al pulsarlo se muestra un cuadro de diálogo con una lista, al pulsar un
elemento de la lista se muestra en un Toast.
*/

public class Actividad2 extends AppCompatActivity {

    private Button btnDialogo;
    // Elementos de la lista del cuadro de diálogo
    private CharSequence[] marcas = {"Lost", "Pukas", "NSP", "Yanes", "JS", "Indo", "Hypto"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        // Cuadro de diálogo con una lista
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.tit_cuadro2))
                .setIcon(R.drawable.ic_launcher_background)
                .setItems(marcas, new DialogInterface.OnClickListener() {
                    // Escuchador al pulsar sobre un elemento del listado
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), marcas[which], Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog dialogo = builder.create();
        // Botón que muestra el cuadro de diálogo
        btnDialogo = (Button) findViewById(R.id.button2);
        btnDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.show();
            }
        });
    }

    // Método para inflar el OptionsMenu del recurso opciones_act2.xml en la Actividad
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opciones_act2, menu);
        return true;
    }

    // Listener del OptionsMenu que inciará la 1º Actividad
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent cambiarActividad;
        cambiarActividad = new Intent(this, MainActivity.class);
        int id = item.getItemId();
        if (id == R.id.CambioAct){
            // Cambio a la actividad principal
            startActivity(cambiarActividad);
        }
        return super.onOptionsItemSelected(item);
    }
}