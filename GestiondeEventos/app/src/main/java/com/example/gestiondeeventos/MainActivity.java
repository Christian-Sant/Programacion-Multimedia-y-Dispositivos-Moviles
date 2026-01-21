package com.example.gestiondeeventos;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnAgregar;
    private ListView listEventos;

    private ArrayList<Evento> listaEventos;
    private ArrayAdapter<Evento> adapter;

    private String fechaSeleccionada;
    private String horaSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAgregar = findViewById(R.id.btnAgregar);
        listEventos = findViewById(R.id.listEventos);

        listaEventos = new ArrayList<>();
        adapter = new ArrayAdapter<Evento>(
                this,
                android.R.layout.simple_list_item_1,
                listaEventos
        ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                // Intercalar colores
                if (position % 2 == 0) {
                    view.setBackgroundColor(0xFFFFFFFF); // blanco
                } else {
                    view.setBackgroundColor(0xFF9E9E9E); // gris claro
                }

                return view;
            }
        };

        // Solicitar permiso de notificaciones en Android 13+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(
                        this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS},
                        100
                );
            }
        }

        listEventos.setAdapter(adapter);

        btnAgregar.setOnClickListener(v -> mostrarDialogoEvento());

        listEventos.setOnItemClickListener((parent, view, position, id) -> {
            Evento evento = listaEventos.get(position);
            mostrarToastPersonalizado(evento);
        });
    }

    private void mostrarDialogoEvento() {
        final EditText input = new EditText(this);
        input.setHint("Nombre del evento");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nuevo evento");
        builder.setView(input);

        builder.setPositiveButton("Continuar", (dialog, which) -> {
            String nombreEvento = input.getText().toString().trim();
            if (!nombreEvento.isEmpty()) {
                mostrarDatePicker(nombreEvento);
            }
        });

        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    private void mostrarDatePicker(final String nombreEvento) {
        Calendar calendario = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {
                    fechaSeleccionada = dayOfMonth + "/" + (month + 1) + "/" + year;
                    mostrarTimePicker(nombreEvento);
                },
                calendario.get(Calendar.YEAR),
                calendario.get(Calendar.MONTH),
                calendario.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.show();
    }

    private void mostrarTimePicker(final String nombreEvento) {
        Calendar calendario = Calendar.getInstance();

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (view, hourOfDay, minute) -> {

                    horaSeleccionada = hourOfDay + ":" + String.format("%02d", minute);

                    Evento evento = new Evento(
                            nombreEvento,
                            fechaSeleccionada,
                            horaSeleccionada
                    );

                    listaEventos.add(evento);
                    adapter.notifyDataSetChanged();

                    // Retrasar la notificación 5 segundos
                    new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(
                            () -> mostrarNotificacion(evento),
                            5000
                    );

                },
                calendario.get(Calendar.HOUR_OF_DAY),
                calendario.get(Calendar.MINUTE),
                true
        );

        timePickerDialog.show();
    }

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
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, canalId)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
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

    private void mostrarToastPersonalizado(Evento evento) {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.notificacion, null);

        TextView texto = layout.findViewById(R.id.txtToast);

        if (texto != null) {
            texto.setText(
                    evento.getNombre() + "\n" +
                            evento.getFecha() + " " +
                            evento.getHora()
            );
        }

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
