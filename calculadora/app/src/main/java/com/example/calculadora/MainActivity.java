package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.calculadora);
        Button coma = findViewById(R.id.coma);
        Button igual = findViewById(R.id.igual);
        Button mas = findViewById(R.id.mas);
        Button menos = findViewById(R.id.menos);
        Button multiplicar = findViewById(R.id.multiplicar);
        Button dividir = findViewById(R.id.dividir);
        Button numeroCero = findViewById(R.id.numeroCero);
        Button numeroUno = findViewById(R.id.numeroUno);
        Button numeroDos = findViewById(R.id.numeroDos);
        Button numeroTres = findViewById(R.id.numeroTres);
        Button numeroCuatro = findViewById(R.id.numeroCuatro);
        Button numeroCinco = findViewById(R.id.numeroCinco);
        Button numeroSeis = findViewById(R.id.numeroSeis);
        Button numeroSiete = findViewById(R.id.numeroSiete);
        Button numeroOcho = findViewById(R.id.numeroOcho);
        Button numeroNueve = findViewById(R.id.numeroNueve);
        TextView texto = findViewById(R.id.texto);
        numeroUno.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(texto.getText().toString().equals("0")){
                    texto.setText("1");
                }
                else{
                    texto.getEditableText().append("1");
                }
            }
        });
        numeroDos.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(texto.getText().toString().equals("0")){
                    texto.setText("2");
                }
                else{
                    texto.getEditableText().append("2");
                }
            }
        });
        numeroTres.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(texto.getText().toString().equals("0")){
                    texto.setText("3");
                }
                else{
                    texto.getEditableText().append("3");
                }
            }
        });
        numeroCuatro.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(texto.getText().toString().equals("0")){
                    texto.setText("4");
                }
                else{
                    texto.getEditableText().append("4");
                }
            }
        });
        numeroCinco.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(texto.getText().toString().equals("0")){
                    texto.setText("5");
                }
                else{
                    texto.getEditableText().append("5");
                }
            }
        });
        numeroSeis.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(texto.getText().toString().equals("0")){
                    texto.setText("6");
                }
                else{
                    texto.getEditableText().append("6");
                }
            }
        });
        numeroSiete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(texto.getText().toString().equals("0")){
                    texto.setText("7");
                }
                else{
                    texto.getEditableText().append("7");
                }
            }
        });
        numeroOcho.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(texto.getText().toString().equals("0")){
                    texto.setText("8");
                }
                else{
                    texto.getEditableText().append("8");
                }
            }
        });
        numeroNueve.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(texto.getText().toString().equals("0")){
                    texto.setText("9");
                }
                else{
                    texto.getEditableText().append("9");
                }
            }
        });
        numeroCero.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(texto.getText().toString().equals("0")){
                    texto.setText("0");
                }
                else{
                    texto.getEditableText().append("0");
                }
            }
        });
        coma.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                    texto.getEditableText().append(".");
            }
        });
        dividir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                texto.getEditableText().append("/");
            }
        });
        mas.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                texto.getEditableText().append("+");
            }
        });
        menos.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                texto.getEditableText().append("-");
            }
        });
        multiplicar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                texto.getEditableText().append("*");
            }
        });
    }

}