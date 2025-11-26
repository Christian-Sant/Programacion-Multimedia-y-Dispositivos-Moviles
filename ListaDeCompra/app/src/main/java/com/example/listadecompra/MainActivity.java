package com.example.listadecompra;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Item> items;
    private CustomAdapter adapter;
    private String[] opciones = {"manzana", "platano", "leche", "pan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        Spinner spinner = findViewById(R.id.miSpinner);
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,opciones);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);
        String nombre = spinner.getSelectedItem().toString();
        int idDrawable = getResources().getIdentifier(nombre, "drawable", getPackageName());
        items = new ArrayList<>();
        Button add = findViewById(R.id.add);
        ListView listado = findViewById(R.id.listView);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                items.add(new Item(idDrawable, nombre));
                adapter.notifyDataSetChanged();
            }
        });
        adapter = new CustomAdapter (this, items);
        listado.setAdapter(adapter);
    }
}