package com.example.calculadora;

import android.os.Bundle;
import android.text.Editable;
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
        setContentView(R.layout.calculadora);//Nos referimos al xml de calculadora
        Button coma = findViewById(R.id.coma);//Nos referimos al id del coma del boton que tenemos en el xml
        Button igual = findViewById(R.id.igual);//Nos referimos al id del igual del boton que tenemos en el xml
        Button mas = findViewById(R.id.mas);//Nos referimos al id del mas del boton que tenemos en el xml
        Button menos = findViewById(R.id.menos);//Nos referimos al id del menos del boton que tenemos en el xml
        Button multiplicar = findViewById(R.id.multiplicar);//Nos referimos al id del multiplicar del boton que tenemos en el xml
        Button dividir = findViewById(R.id.dividir);//Nos referimos al id del dividir del boton que tenemos en el xml
        Button numeroCero = findViewById(R.id.numeroCero);//Nos referimos al id del numero 0 del boton que tenemos en el xml
        Button numeroUno = findViewById(R.id.numeroUno);//Nos referimos al id del numero 1 del boton que tenemos en el xml
        Button numeroDos = findViewById(R.id.numeroDos);//Nos referimos al id del numero 2 del boton que tenemos en el xml
        Button numeroTres = findViewById(R.id.numeroTres);//Nos referimos al id del numero 3 del boton que tenemos en el xml
        Button numeroCuatro = findViewById(R.id.numeroCuatro);//Nos referimos al id del numero 4 del boton que tenemos en el xml
        Button numeroCinco = findViewById(R.id.numeroCinco);//Nos referimos al id del numero 5 del boton que tenemos en el xml
        Button numeroSeis = findViewById(R.id.numeroSeis);//Nos referimos al id del numero 6 del boton que tenemos en el xml
        Button numeroSiete = findViewById(R.id.numeroSiete);//Nos referimos al id del numero 7 del boton que tenemos en el xml
        Button numeroOcho = findViewById(R.id.numeroOcho);//Nos referimos al id del numero 8 del boton que tenemos en el xml
        Button numeroNueve = findViewById(R.id.numeroNueve);//Nos referimos al id del numero 9 del boton que tenemos en el xml
        Button quitarUno = findViewById(R.id.C);//Nos referimos al id de quitar un caracter del boton que tenemos en el xml
        Button quitarTodo = findViewById(R.id.AC);//Nos referimos al id de quitar todos los caracteres del boton que tenemos en el xml
        TextView texto = findViewById(R.id.texto);//Nos referimos al id del textView en el xml
        numeroUno.setOnClickListener(new View.OnClickListener(){
            /**
             * Este metodo al hacer click sobre el boton para el numero 1 comprobaremos primero que haya mas de 1 caracter el texto
             * y si tiene, empezamos a comprobar que si el penultimo es un operador y el ultimo es un cero
             * que se cambie al numero seleccionado quitando el cero y poniendo el numero que debe ser y
             * tenemos otro if y else que sirve para que si solo existe el 0 que ponga el numero quitando el 0
             * y en el else que se añada
             * @param view The view that was clicked.
             */
            public void onClick(View view) {
                int length = texto.getText().toString().length();//recogemos cuantos caracteres tiene
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//cogemos el ultimo caracter
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);//cogemos el penultimo caracter
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("1");
                }
                else{
                    texto.getEditableText().append("1");
                }
            }
        });

        numeroDos.setOnClickListener(new View.OnClickListener(){
            /**
             * Este metodo al hacer click sobre el boton para el numero 2 comprobaremos primero que haya mas de 1 caracter el texto
             * y si tiene, empezamos a comprobar que si el penultimo es un operador y el ultimo es un cero
             * que se cambie al numero seleccionado quitando el cero y poniendo el numero que debe ser y
             * tenemos otro if y else que sirve para que si solo existe el 0 que ponga el numero quitando el 0
             * y en el else que se añada
             * @param view The view that was clicked.
             */
            public void onClick(View view){
                int length = texto.getText().toString().length();//recogemos cuantos caracteres tiene
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//cogemos el ultimo caracter
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);//cogemos el penultimo caracter
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("2");
                }
                else{
                    texto.getEditableText().append("2");
                }
            }
        });
        numeroTres.setOnClickListener(new View.OnClickListener(){
            /**
             * Este metodo al hacer click sobre el boton para el numero 3 comprobaremos primero que haya mas de 1 caracter el texto
             * y si tiene, empezamos a comprobar que si el penultimo es un operador y el ultimo es un cero
             * que se cambie al numero seleccionado quitando el cero y poniendo el numero que debe ser y
             * tenemos otro if y else que sirve para que si solo existe el 0 que ponga el numero quitando el 0
             * y en el else que se añada
             * @param view The view that was clicked.
             */
            public void onClick(View view){
                int length = texto.getText().toString().length();//recogemos cuantos caracteres tiene
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//cogemos el ultimo caracter
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);//cogemos el penultimo caracter
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("3");
                }
                else{
                    texto.getEditableText().append("3");
                }
            }
        });
        numeroCuatro.setOnClickListener(new View.OnClickListener(){
            /**
             * Este metodo al hacer click sobre el boton para el numero 4 comprobaremos primero que haya mas de 1 caracter el texto
             * y si tiene, empezamos a comprobar que si el penultimo es un operador y el ultimo es un cero
             * que se cambie al numero seleccionado quitando el cero y poniendo el numero que debe ser y
             * tenemos otro if y else que sirve para que si solo existe el 0 que ponga el numero quitando el 0
             * y en el else que se añada
             * @param view The view that was clicked.
             */
            public void onClick(View view){
                int length = texto.getText().toString().length();//recogemos cuantos caracteres tiene
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//cogemos el ultimo caracter
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);//cogemos el penultimo caracter
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("4");
                }
                else{
                    texto.getEditableText().append("4");
                }
            }
        });
        numeroCinco.setOnClickListener(new View.OnClickListener(){
            /**
             * Este metodo al hacer click sobre el boton para el numero 5 comprobaremos primero que haya mas de 1 caracter el texto
             * y si tiene, empezamos a comprobar que si el penultimo es un operador y el ultimo es un cero
             * que se cambie al numero seleccionado quitando el cero y poniendo el numero que debe ser y
             * tenemos otro if y else que sirve para que si solo existe el 0 que ponga el numero quitando el 0
             * y en el else que se añada
             * @param view The view that was clicked.
             */
            public void onClick(View view){
                int length = texto.getText().toString().length();//recogemos cuantos caracteres tiene
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//cogemos el ultimo caracter
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);//cogemos el penultimo caracter
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("5");
                }
                else{
                    texto.getEditableText().append("5");
                }
            }
        });
        numeroSeis.setOnClickListener(new View.OnClickListener(){
            /**
             * Este metodo al hacer click sobre el boton para el numero 6 comprobaremos primero que haya mas de 1 caracter el texto
             * y si tiene, empezamos a comprobar que si el penultimo es un operador y el ultimo es un cero
             * que se cambie al numero seleccionado quitando el cero y poniendo el numero que debe ser y
             * tenemos otro if y else que sirve para que si solo existe el 0 que ponga el numero quitando el 0
             * y en el else que se añada
             * @param view The view that was clicked.
             */
            public void onClick(View view){
                int length = texto.getText().toString().length();//recogemos cuantos caracteres tiene
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//cogemos el ultimo caracter
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);//cogemos el penultimo caracter
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("6");
                }
                else{
                    texto.getEditableText().append("6");
                }
            }
        });
        numeroSiete.setOnClickListener(new View.OnClickListener(){
            /**
             * Este metodo al hacer click sobre el boton para el numero 7 comprobaremos primero que haya mas de 1 caracter el texto
             * y si tiene, empezamos a comprobar que si el penultimo es un operador y el ultimo es un cero
             * que se cambie al numero seleccionado quitando el cero y poniendo el numero que debe ser y
             * tenemos otro if y else que sirve para que si solo existe el 0 que ponga el numero quitando el 0
             * y en el else que se añada
             * @param view The view that was clicked.
             */
            public void onClick(View view){
                int length = texto.getText().toString().length();//recogemos cuantos caracteres tiene
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//cogemos el ultimo caracter
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);//cogemos el penultimo caracter
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("7");
                }
                else{
                    texto.getEditableText().append("7");
                }
            }
        });
        numeroOcho.setOnClickListener(new View.OnClickListener(){
            /**
             * Este metodo al hacer click sobre el boton para el numero 8 comprobaremos primero que haya mas de 1 caracter el texto
             * y si tiene, empezamos a comprobar que si el penultimo es un operador y el ultimo es un cero
             * que se cambie al numero seleccionado quitando el cero y poniendo el numero que debe ser y
             * tenemos otro if y else que sirve para que si solo existe el 0 que ponga el numero quitando el 0
             * y en el else que se añada
             * @param view The view that was clicked.
             */
            public void onClick(View view){
                int length = texto.getText().toString().length();//recogemos cuantos caracteres tiene
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//cogemos el ultimo caracter
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);//cogemos el penultimo caracter
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("8");
                }
                else{
                    texto.getEditableText().append("8");
                }
            }
        });
        numeroNueve.setOnClickListener(new View.OnClickListener(){
            /**
             * Este metodo al hacer click sobre el boton para el numero 9 comprobaremos primero que haya mas de 1 caracter el texto
             * y si tiene, empezamos a comprobar que si el penultimo es un operador y el ultimo es un cero
             * que se cambie al numero seleccionado quitando el cero y poniendo el numero que debe ser y
             * tenemos otro if y else que sirve para que si solo existe el 0 que ponga el numero quitando el 0
             * y en el else que se añada
             * @param view The view that was clicked.
             */
            public void onClick(View view){
                int length = texto.getText().toString().length();//recogemos cuantos caracteres tiene
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//cogemos el ultimo caracter
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);//cogemos el penultimo caracter
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("9");
                }
                else{
                    texto.getEditableText().append("9");
                }
            }
        });
        numeroCero.setOnClickListener(new View.OnClickListener(){
            /**
             * Este metodo al hacer click sobre el boton para el numero 0 comprobaremos primero que haya mas de 1 caracter el texto
             * y si tiene, empezamos a comprobar que si el penultimo es un operador y el ultimo es un cero
             * que se cambie al numero seleccionado quitando el cero y poniendo el numero que debe ser y
             * tenemos otro if y else que sirve para que si solo existe el 0 que ponga el numero quitando el 0
             * y en el else que se añada
             * @param view The view that was clicked.
             */
            public void onClick(View view){
                int length = texto.getText().toString().length();//recogemos cuantos caracteres tiene
                if (length > 1){
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//cogemos el ultimo caracter
                    char penultimoCaracter = texto.getText().toString().charAt(length - 2);//cogemos el penultimo caracter
                    if (ultimoCaracter == '0') {
                        if (penultimoCaracter == '/' || penultimoCaracter == '+' || penultimoCaracter == '-' || penultimoCaracter == '*') {
                            texto.getEditableText().delete(length - 1, length);
                        }
                    }
                }
                if(texto.getText().toString().equals("0")){
                    texto.setText("0");
                }
                else{
                    texto.getEditableText().append("0");
                }
            }
        });
        coma.setOnClickListener(new View.OnClickListener() {
            /**
             * Este metodo al hacer click sobre el boton coma, se asegura de que no se pueda poner mas
             * de una coma a menos de que haya un operador que los separen con los nuevos numeros
             * @param view The view that was clicked.
             */
            public void onClick(View view) {
                String textoActual = texto.getEditableText().toString();//numero de caracteres totales
                if (textoActual.isEmpty()) return;
                char ultimoChar = textoActual.charAt(textoActual.length() - 1);//ultimo caracter
                if (!Character.isDigit(ultimoChar)) return;
                char[] operadores = {'+', '-', '*', '/'};//un array de los operadores
                int ubicacion = -1;//un int para usarlo en la busqueda de operador
                for (char operador : operadores) {
                    int i = textoActual.lastIndexOf(operador);
                    if (i > ubicacion) {
                        ubicacion = i;
                    }
                }
                String numeroActual = textoActual.substring(ubicacion + 1);//asegura de dar el indice donde debe poner la coma
                if (!numeroActual.contains(".")) {
                    texto.getEditableText().append(".");
                }
            }
        });

        dividir.setOnClickListener(new View.OnClickListener(){
            /**
             * Este metodo al hacer click sobre el boton dividir, primero se asegura de que no haya
             * ningun otro operador y si se encuentra que se elimine y se ponga este.
             * @param view The view that was clicked.
             */
            public void onClick(View view) {
                int length = texto.getText().length();//numero de caracteres en total
                if (length > 0) {
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//conseguir el ultimo caracter
                    if (ultimoCaracter == '-' || ultimoCaracter == '*' || ultimoCaracter == '+') {
                        texto.getEditableText().delete(length - 1, length);
                    }
                }
                texto.getEditableText().append("/");
            }
        });
        mas.setOnClickListener(new View.OnClickListener(){
            /**
             * Este metodo al hacer click sobre el boton mas, primero se asegura de que no haya
             * ningun otro operador y si se encuentra que se elimine y se ponga este.
             * @param view The view that was clicked.
             */
            public void onClick(View view) {
                int length = texto.getText().length();//numero de caracteres en total
                if (length > 0) {
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//conseguir el ultimo caracter
                    if (ultimoCaracter == '-' || ultimoCaracter == '*' || ultimoCaracter == '/') {
                        texto.getEditableText().delete(length - 1, length);
                    }
                }
                texto.getEditableText().append("+");
            }
        });
        menos.setOnClickListener(new View.OnClickListener(){
            /**
             * Este metodo al hacer click sobre el boton menos, primero se asegura de que no haya
             * ningun otro operador y si se encuentra que se elimine y se ponga este.
             * @param view The view that was clicked.
             */
            public void onClick(View view) {
                int length = texto.getText().length();//numero de caracteres en total
                if (length > 0) {
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//conseguir el ultimo caracter
                    if (ultimoCaracter == '+' || ultimoCaracter == '*' || ultimoCaracter == '/') {
                        texto.getEditableText().delete(length - 1, length);
                    }
                }
                texto.getEditableText().append("-");
            }
        });
        multiplicar.setOnClickListener(new View.OnClickListener() {
            /**
             * Este metodo al hacer click sobre el boton multiplicar, primero se asegura de que no haya
             * ningun otro operador y si se encuentra que se elimine y se ponga este.
             * @param view The view that was clicked.
             */
            public void onClick(View view) {
                int length = texto.getText().length();//numero de caracteres en total
                if (length > 0) {
                    char ultimoCaracter = texto.getText().toString().charAt(length - 1);//conseguir el ultimo caracter
                    if (ultimoCaracter == '+' || ultimoCaracter == '-' || ultimoCaracter == '/') {
                        texto.getEditableText().delete(length - 1, length);
                    }
                }
                texto.getEditableText().append("*");
            }
        });
        quitarUno.setOnClickListener(new View.OnClickListener(){
            /**
             * Este motodo al hacer click sobre el boton quitarUno va quitando uno por uno el ultimo caracter
             * @param view The view that was clicked.
             */
            public void onClick(View view){
                int length = texto.getText().length();//el numero total de caracteres
                if(length > 0) {
                    texto.getEditableText().delete(length - 1, length);
                    if(texto.getText().length() == 0){
                        texto.setText("0");
                    }
                }
            }
        });
        quitarTodo.setOnClickListener(new View.OnClickListener(){
            /**
             * ste motodo al hacer click sobre el boton quitarTodo, se encargar de quitar todos los caracteres poniendo
             * por defecto el cero
             * @param view The view that was clicked.
             */
            public void onClick(View view){
                int length = texto.getText().length();//el numero total de caracteres
                if(length > 0){
                    texto.setText("0");
                }
            }
        });
        igual.setOnClickListener(new View.OnClickListener(){
            /**
             * Este no esta en funcionamiento
             * @param view The view that was clicked.
             */
            public void onClick(View view){

            }
        });
    }

}