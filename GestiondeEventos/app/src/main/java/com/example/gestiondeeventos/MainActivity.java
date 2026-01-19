package com.example.gestiondeeventos;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // 📌 Componentes de la interfaz
    private Button btnAgregar;
    private ListView listEventos;

    // 📌 Datos
    private ArrayList<Evento> listaEventos;
    private ArrayAdapter<Evento> adapter;

    // 📌 Fecha y hora seleccionadas
    private String fechaSeleccionada;
    private String horaSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 🔹 Referencias a vistas
        btnAgregar = findViewById(R.id.btnAgregar);
        listEventos = findViewById(R.id.listEventos);

        // 🔹 Inicializar lista y adaptador
        listaEventos = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listaEventos
        );
        listEventos.setAdapter(adapter);

        // 🔹 Botón para añadir evento
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoEvento();
            }
        });

        // 🔹 Pulsar sobre un evento → Toast personalizado
        listEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Evento evento = listaEventos.get(position);
                mostrarToastPersonalizado(evento);
            }
        });
    }

    // =========================================================
    // ALERT DIALOG – Nombre del evento
    // =========================================================
    private void mostrarDialogoEvento() {

        final EditText input = new EditText(this);
        input.setHint("Nombre del evento");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nuevo evento");
        builder.setView(input);

        builder.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String nombreEvento = input.getText().toString();

                if (!nombreEvento.isEmpty()) {
                    mostrarDatePicker(nombreEvento);
                }
            }
        });

        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    // =========================================================
    // DATE PICKER DIALOG
    // =========================================================
    private void mostrarDatePicker(final String nombreEvento) {

        Calendar calendario = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fechaSeleccionada = dayOfMonth + "/" + (month + 1) + "/" + year;
                        mostrarTimePicker(nombreEvento);
                    }
                },
                calendario.get(Calendar.YEAR),
                calendario.get(Calendar.MONTH),
                calendario.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.show();
    }

    // =========================================================
    // TIME PICKER DIALOG
    // =========================================================
    private void mostrarTimePicker(final String nombreEvento) {

        Calendar calendario = Calendar.getInstance();

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        horaSeleccionada = hourOfDay + ":" +
                                String.format("%02d", minute);

                        Evento evento = new Evento(
                                nombreEvento,
                                fechaSeleccionada,
                                horaSeleccionada
                        );

                        listaEventos.add(evento);
                        adapter.notifyDataSetChanged();

                        mostrarNotificacion(evento);
                    }
                },
                calendario.get(Calendar.HOUR_OF_DAY),
                calendario.get(Calendar.MINUTE),
                true
        );

        timePickerDialog.show();
    }

    // =========================================================
    // NOTIFICACIÓN DEL SISTEMA
    // =========================================================
    private void mostrarNotificacion(Evento evento) {

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        String canalId = "canal_eventos";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    canalId,
                    "Eventos",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(channel);
        }

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, canalId)
                        .setSmallIcon(R.drawable.ic_event)
                        .setContentTitle("Evento creado")
                        .setContentText(
                                evento.getNombre() + " - " +
                                        evento.getFecha() + " " +
                                        evento.getHora()
                        )
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);

        notificationManager.notify(1, builder.build());
    }

    // =========================================================
    // TOAST PERSONALIZADO
    // =========================================================
    private void mostrarToastPersonalizado(Evento evento) {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_custom, null);

        TextView texto = layout.findViewById(R.id.txtToast);
        texto.setText(
                evento.getNombre() + "\n" +
                        evento.getFecha() + " " +
                        evento.getHora()
        );

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}