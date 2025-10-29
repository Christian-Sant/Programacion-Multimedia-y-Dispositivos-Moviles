package com.example.tema4edittext;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.l1);
        String [] opciones = {"opcion1", "opcion2", "opcion3", "opcion4"};
        AutoCompleteTextView textoLeido = findViewById(R.id.autoCompletado);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,opciones);
        textoLeido.setAdapter(adaptador);
        Spinner miSpinner = (Spinner) findViewById(R.id.miSpinner);
        String[] valores = {"","hola","adios"};
        miSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores));
        CheckBox checkbox1 = findViewById(R.id.checkbox1);
        TextView texto = findViewById(R.id.texto);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l){
                System.out.println("Has seleccionado el valor: " +adapterView.getItemAtPosition(position));
            }
            public void onNothingSelected(AdapterView<?> adapterView){
                System.out.println("No has seleccionado nada");
            }
        });
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,"Checkbox Seleccionado", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Checkbox Desseleccionado", Toast.LENGTH_SHORT).show();

                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                if(selectedId != 1){
                    texto.setText(selectedRadioButton.getText().toString());
                }
            }
        });
    }
}