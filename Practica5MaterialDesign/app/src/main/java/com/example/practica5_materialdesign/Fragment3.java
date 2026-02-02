package com.example.practica5_materialdesign;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.activity.EdgeToEdge;

public class Fragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflamos el layout de la calculadora
        View root = inflater.inflate(R.layout.fragment_3, container, false);

        EdgeToEdge.enable(requireActivity());

        Button coma = root.findViewById(R.id.coma);
        Button igual = root.findViewById(R.id.igual);
        Button mas = root.findViewById(R.id.mas);
        Button menos = root.findViewById(R.id.menos);
        Button multiplicar = root.findViewById(R.id.multiplicar);
        Button dividir = root.findViewById(R.id.dividir);
        Button numeroCero = root.findViewById(R.id.numeroCero);
        Button numeroUno = root.findViewById(R.id.numeroUno);
        Button numeroDos = root.findViewById(R.id.numeroDos);
        Button numeroTres = root.findViewById(R.id.numeroTres);
        Button numeroCuatro = root.findViewById(R.id.numeroCuatro);
        Button numeroCinco = root.findViewById(R.id.numeroCinco);
        Button numeroSeis = root.findViewById(R.id.numeroSeis);
        Button numeroSiete = root.findViewById(R.id.numeroSiete);
        Button numeroOcho = root.findViewById(R.id.numeroOcho);
        Button numeroNueve = root.findViewById(R.id.numeroNueve);
        Button quitarUno = root.findViewById(R.id.C);
        Button quitarTodo = root.findViewById(R.id.AC);
        TextView texto = root.findViewById(R.id.texto);

        // --- Copiamos exactamente la misma lógica de MainActivity ---

        numeroUno.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                int length = texto.getText().toString().length();
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("1");
                } else {
                    texto.getEditableText().append("1");
                }
            }
        });

        numeroDos.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int length = texto.getText().toString().length();
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("2");
                } else {
                    texto.getEditableText().append("2");
                }
            }
        });

        numeroTres.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int length = texto.getText().toString().length();
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("3");
                } else {
                    texto.getEditableText().append("3");
                }
            }
        });

        numeroCuatro.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int length = texto.getText().toString().length();
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("4");
                } else {
                    texto.getEditableText().append("4");
                }
            }
        });

        numeroCinco.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int length = texto.getText().toString().length();
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("5");
                } else {
                    texto.getEditableText().append("5");
                }
            }
        });

        numeroSeis.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int length = texto.getText().toString().length();
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("6");
                } else {
                    texto.getEditableText().append("6");
                }
            }
        });

        numeroSiete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int length = texto.getText().toString().length();
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("7");
                } else {
                    texto.getEditableText().append("7");
                }
            }
        });

        numeroOcho.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int length = texto.getText().toString().length();
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("8");
                } else {
                    texto.getEditableText().append("8");
                }
            }
        });

        numeroNueve.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int length = texto.getText().toString().length();
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("9");
                } else {
                    texto.getEditableText().append("9");
                }
            }
        });

        numeroCero.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int length = texto.getText().toString().length();
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("0");
                } else {
                    texto.getEditableText().append("0");
                }
            }
        });

        // --- Botones de operaciones, coma, AC, C e igual ---

        coma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String textoActual = texto.getEditableText().toString();
                if (textoActual.isEmpty()) return;
                char ultimoChar = textoActual.charAt(textoActual.length() - 1);
                if (!Character.isDigit(ultimoChar)) return;
                char[] operadores = {'+', '-', '*', '/'};
                int ubicacion = -1;
                for (char operador : operadores) {
                    int i = textoActual.lastIndexOf(operador);
                    if (i > ubicacion) {
                        ubicacion = i;
                    }
                }
                String numeroActual = textoActual.substring(ubicacion + 1);
                if (!numeroActual.contains(".")) {
                    texto.getEditableText().append(".");
                }
            }
        });

        dividir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                int length = texto.getText().length();
                if (length > 0) {
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    if (ultimoCaracter == '-' || ultimoCaracter == '*' || ultimoCaracter == '+') {
                        texto.getEditableText().delete(length - 1, length);
                    }
                }
                texto.getEditableText().append("/");
            }
        });

        mas.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                int length = texto.getText().length();
                if (length > 0) {
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    if (ultimoCaracter == '-' || ultimoCaracter == '*' || ultimoCaracter == '/') {
                        texto.getEditableText().delete(length - 1, length);
                    }
                }
                texto.getEditableText().append("+");
            }
        });

        menos.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                int length = texto.getText().length();
                if (length > 0) {
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    if (ultimoCaracter == '+' || ultimoCaracter == '*' || ultimoCaracter == '/') {
                        texto.getEditableText().delete(length - 1, length);
                    }
                }
                texto.getEditableText().append("-");
            }
        });

        multiplicar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int length = texto.getText().length();
                if (length > 0) {
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);
                    if (ultimoCaracter == '+' || ultimoCaracter == '-' || ultimoCaracter == '/') {
                        texto.getEditableText().delete(length - 1, length);
                    }
                }
                texto.getEditableText().append("*");
            }
        });

        quitarUno.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int length = texto.getText().length();
                if(length > 0) {
                    texto.getEditableText().delete(length - 1, length);
                    if(texto.getText().length() == 0){
                        texto.setText("0");
                    }
                }
            }
        });

        quitarTodo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int length = texto.getText().length();
                if(length > 0){
                    texto.setText("0");
                }
            }
        });

        igual.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // Tu método de igual no estaba implementado
            }
        });

        return root;
    }
}
