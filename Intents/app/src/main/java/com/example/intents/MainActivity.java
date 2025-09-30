package com.example.intents;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ejemplo", "Estoy en on Destroy");
        Intent ejemplo = new Intent(this, MainActivity2.class);
        startActivity(ejemplo);
    }
}