package com.example.tema4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private boolean play = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tp1);
        ToggleButton boton = findViewById(R.id.tooglebutton1);//Nos referimos al id de quitar todos los caracteres del boton que tenemos en el xml
        TextView texto = findViewById(R.id.texto);//Nos referimos al id del textView en el
        ImageButton imagen = findViewById(R.id.imagenBoton);
        boton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    texto.setText("Estado: Pulsado");
                } else {
                    texto.setText("Estado: No pulsado");
                }
            }
        });
        imagen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(play){
                    imagen.setImageResource(R.drawable.botn1);
                    play = false;
                }
                else{
                    imagen.setImageResource(R.drawable.btn2);
                    play = true;
                }
                Toast.makeText(MainActivity.this,"Has pulsado el ImagenButton", Toast.LENGTH_SHORT).show();
            }
        });
    }
}