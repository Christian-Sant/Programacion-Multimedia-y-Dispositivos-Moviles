package com.example.tema4edittext;

import static android.widget.SeekBar.*;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.Switch;
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
        setContentView(R.layout.scroll);
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
        Switch switch1 =  findViewById(R.id.switch1);
        SeekBar seekBar = findViewById(R.id.seekBar);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
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
        // Listener para el cambio de estado del Switch
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    texto.setText("Estado: Encendido");
                } else {
                    texto.setText("Estado: Apagado");
                }
            }
        });
        // Listener para cambios en el SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // Método que se llama cuando cambia el progreso
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                texto.setText("Valor: " + progress);
            }

            // Método que se llama cuando el usuario empieza a tocar el SeekBar
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Aquí puedes añadir lógica si necesitas hacer algo cuando el usuario empieza a mover el SeekBar
            }

            // Método que se llama cuando el usuario deja de tocar el SeekBar
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Aquí puedes añadir lógica si necesitas hacer algo cuando el usuario termina de mover el SeekBar
            }
        });
        // Listener para cambios en la calificación del RatingBar
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                texto.setText("Calificación: " + rating);
            }
        });
        ProgressBar pb = findViewById(R.id.pbDet);
        ProgressBar pbInt = findViewById(R.id.pbIndet);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            int v = 0;
            @Override public void run() {
                if (v<=10000) {
                    pb.setProgress(v+=5);
                    new Handler(Looper.getMainLooper()).postDelayed(this, 200);
                }
            }
        },  200);
    }
}