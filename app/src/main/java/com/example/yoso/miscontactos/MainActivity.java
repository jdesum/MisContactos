package com.example.yoso.miscontactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Declaración del Array List y obj contacto
    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instancio el obj contactos
        contactos = new ArrayList<>();

        // Añado cinco contactos lista dummy
        contactos.add(new Contacto("Jordi Desum", "66665555", "jdesum@gmail.com"));
        contactos.add(new Contacto("Pedro Sanchez", "88882222", "pedro@gmail.com"));
        contactos.add(new Contacto("Mireya Martinez", "7779999", "mireya@gmail.com"));
        contactos.add(new Contacto("Juan Lopez", "5559999", "juan@gmail.com"));
        contactos.add(new Contacto("Eva Rodriguez", "77775555", "eva@gmail.com"));

        // Pasamos un nuevo arreglo de contactos
        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto : contactos){
            nombresContacto.add(contacto.getNombre());

        }


        // Lista de contacto del layout
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);

        // Es necesario un adaptador
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));


        // Creación de un intent explicito utilizando la class intent
        // Crear un listener para captar un click en la lista

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Declaro e instacio el intent
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);

                // Enviar un intent con parámetros Es un intent Explicito
               /* intent.putExtra("Nombre", contactos.get(position).getNombre());
                intent.putExtra("Telefono", contactos.get(position).getTelefono());
                intent.putExtra("Email", contactos.get(position).getEmail());
                */
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);

                // Fianlizar la actividad anterior
                finish();

            }
        });


    }
}
