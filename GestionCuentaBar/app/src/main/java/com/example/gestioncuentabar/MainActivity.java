package com.example.gestioncuentabar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
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
        setContentView(R.layout.linea);
        EditText cuenta = findViewById(R.id.cuenta);
        CheckBox propina = findViewById(R.id.propina);
        TextView porcentajePropina = findViewById(R.id.porcentajePropina);
        SeekBar porcentaje = findViewById(R.id.porcentaje);
        RadioGroup radioGroupPago = findViewById(R.id.radioGroupPago);
        RatingBar calificacion = findViewById(R.id.calificacion);
        Button calcular = findViewById(R.id.calcular);
        TextView calculo = findViewById(R.id.calculo);
        porcentajePropina.setVisibility(TextView.GONE);
        porcentaje.setVisibility(SeekBar.GONE);
        AutoCompleteTextView camarero = findViewById(R.id.camarero);
        String[] camareros = {"Carlos","Laura","Miguel", "Ana", "Javier", "Sofía", "Andrés"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,camareros);
        camarero.setAdapter(adapter);
        propina.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    porcentajePropina.setVisibility(TextView.VISIBLE);
                    porcentaje.setProgress(10);
                    porcentaje.setVisibility(SeekBar.VISIBLE);
                    porcentajePropina.setText(getString(R.string.porcentaje) + String.valueOf(porcentaje.getProgress()) + "%");
                }
                else{
                    porcentaje.setProgress(0);
                    porcentajePropina.setVisibility(TextView.GONE);
                    porcentaje.setVisibility(SeekBar.GONE);
                }
            }
        });

        porcentaje.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentajePropina.setText(getString(R.string.porcentaje) + String.valueOf(progress)  + "%");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        final String[] SELECCIONADO = new String[1];
        radioGroupPago.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedId = radioGroupPago.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                if(selectedId != 1){
                    SELECCIONADO[0] = selectedRadioButton.getText().toString();
                }
            }
        });
        final double[] calificacionServicio = new double[1];
        calificacion.setRating(5);
        calificacionServicio[0] = calificacion.getRating();
        calificacion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                calificacionServicio[0] = rating;
            }
        });
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String camareroAtendido = camarero.getText().toString();
                if (camareroAtendido.isEmpty()) {
                    Toast.makeText(MainActivity.this, getString(R.string.nombreCamarero), Toast.LENGTH_SHORT).show();
                    return;
                }
                String cuentaTexto = cuenta.getText().toString();
                if (cuentaTexto.isEmpty() || Double.parseDouble(cuentaTexto) <= 0) {
                    Toast.makeText(MainActivity.this, getString(R.string.valor), Toast.LENGTH_SHORT).show();
                    return;
                }
                int selectedId = radioGroupPago.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, getString(R.string.metodo), Toast.LENGTH_SHORT).show();
                    return;
                }
                double cuentaIngresada = Double.parseDouble(cuentaTexto);
                int porcentajePropina = porcentaje.getProgress();
                double propina = cuentaIngresada * porcentajePropina / 100.0;
                double total = cuentaIngresada + propina;

                calculo.setText(
                                getString(R.string.atendido) + camarero.getText().toString() +
                                getString(R.string.cuenta) + String.valueOf(cuentaIngresada) + "€" +
                                getString(R.string.propinaTexto) + String.valueOf(propina) + "€" +
                                getString(R.string.totalTexto) + String.valueOf(total) + "€" +
                                getString(R.string.metodoDePago) + SELECCIONADO[0] +
                                getString(R.string.calificacionServicio) + String.valueOf(calificacionServicio[0])
                );

            }
        });

    }
}