package com.example.listadecompra;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Item> items;
    private CustomAdapter adapter;

    // Textos traducidos (lo que ve el usuario)
    private String[] opcionesTraductor;

    // Nombres reales de los drawables (sin traducir)
    private String[] opcionesImagenes = {"manzana", "platano", "leche", "pan", "galletas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);

        // Traducciones desde strings.xml
        opcionesTraductor = new String[] {
                getString(R.string.manzana),
                getString(R.string.platano),
                getString(R.string.leche),
                getString(R.string.pan),
                getString(R.string.galletas)
        };

        Spinner spinner = findViewById(R.id.miSpinner);
        ImageView itemImage = findViewById(R.id.itemImage);
        Button add = findViewById(R.id.add);
        ListView listado = findViewById(R.id.listView);

        // --- Imagen inicial ---
        int resIdPrincipio = getResources().getIdentifier(opcionesImagenes[0], "drawable", getPackageName());
        itemImage.setImageResource(resIdPrincipio);

        // --- Spinner con textos traducidos ---
        ArrayAdapter<String> adapterSpinner =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcionesTraductor);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        // --- Cambiar imagen al seleccionar en el Spinner ---
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Usamos los nombres reales de los drawables
                String nombreDrawable = opcionesImagenes[position];
                int drawableId = getResources().getIdentifier(nombreDrawable, "drawable", getPackageName());
                itemImage.setImageResource(drawableId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // --- Lista y Adapter ---
        items = new ArrayList<>();
        adapter = new CustomAdapter(this, items);
        listado.setAdapter(adapter);

        // --- Botón Añadir ---
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = spinner.getSelectedItemPosition();

                // Texto traducido para mostrar en la lista
                String nombreTraducido = opcionesTraductor[position];

                // Nombre real de drawable
                String nombreDrawable = opcionesImagenes[position];
                int drawableId =
                        getResources().getIdentifier(nombreDrawable, "drawable", getPackageName());

                // Agregar a la lista
                items.add(new Item(drawableId, nombreTraducido));

                // Actualizar ListView
                adapter.notifyDataSetChanged();
            }
        });
    }
}
