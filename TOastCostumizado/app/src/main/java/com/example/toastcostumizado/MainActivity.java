package com.example.toastcostumizado;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.prueba);
        Button pulsar = findViewById(R.id.btnPulsar);

        pulsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarToast(v);

            }
        });*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //showAlertDialog(); // Mostrar un AlertDialog
        //mostrarToast(v);
        TextView textViewDate = findViewById(R.id.textViewDate);
        //showDatePickerDialog(textViewDate);
        showTimePickerDialog(textViewDate);
    }
    // Método para mostrar un TimePickerDialog
    private void showTimePickerDialog(TextView resultTextView) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (view, selectedHour, selectedMinute) -> {
                    String selectedTime = selectedHour + ":" + String.format("%02d", selectedMinute);
                    resultTextView.setText("Hora seleccionada: " + selectedTime);
                },
                hour, minute, true
        );
        timePickerDialog.show();
    }
    private void showDatePickerDialog(TextView resultTextView) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    resultTextView.setText("Fecha seleccionada: " + selectedDate);}, year, month, day);

        datePickerDialog.show();
    }
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Título del Diálogo")
                .setMessage("Este es el mensaje del diálogo.")
                .setIcon(android.R.drawable.ic_dialog_alert) // Using a system icon
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción al presionar "Aceptar"
                        Toast.makeText(MainActivity.this, "Aceptar presionado", Toast.LENGTH_SHORT).show();
                        dialog.dismiss(); // Dismiss the dialog
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción al presionar "Cancelar"
                        Toast.makeText(MainActivity.this, "Cancelar presionado", Toast.LENGTH_SHORT).show();
                        dialog.dismiss(); // Dismiss the dialog
                    }
                })
                .setNeutralButton("Ignorar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Acción al presionar "Ignorar"
                        Toast.makeText(MainActivity.this, "Ignorar presionado", Toast.LENGTH_SHORT).show();
                        dialog.dismiss(); // Dismiss the dialog
                    }
                });
        builder.create().show(); // Mostrar el diálogo
    }
    /*public void mostrarToast(View view) {
        Toast toast = Toast.makeText(this, "¡Botón pulsado!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

        // Inflate the custom layout
        LayoutInflater inflater = getLayoutInflater();
        View customView = inflater.inflate(R.layout.toats, null);
        Toast toast = new Toast(getApplicationContext());
        toast.setView(customView);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 100);
        toast.show();
    }*/
}