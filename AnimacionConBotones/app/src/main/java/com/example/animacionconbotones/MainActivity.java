package com.example.animacionconbotones;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Animation n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.linea);

    }

    protected void onStart(){
        super.onStart();
        TextView miTexto = (TextView) findViewById(R.id.prueba);
        Animation n1= AnimationUtils.loadAnimation(this,R.anim.n1);
        n1.setRepeatMode(Animation.RESTART);
        n1.setRepeatCount(20);
        n2= AnimationUtils.loadAnimation(this,R.anim.n2);
        /*n2.setRepeatMode(Animation.RESTART);
        n2.setRepeatCount(20);*/
        Button boton1 = findViewById(R.id.derecha);
        Button boton2 = findViewById(R.id.rotar);
        Button boton3 = findViewById(R.id.detener);
        boton1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                n2.cancel();
                miTexto.clearAnimation();
                miTexto.startAnimation(n1);

            }
        });
        boton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Log.i("boton2","Entro en boton 2");
                n1.cancel();
                miTexto.clearAnimation();
                n2= AnimationUtils.loadAnimation(MainActivity.this,R.anim.n2);
                miTexto.startAnimation(n2);
                miTexto.setText("Ponte a rotar!!!");
            }
        });
        boton3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                    miTexto.clearAnimation();
                    n1.cancel();
                    n2.cancel();
            }
        });
    }

}