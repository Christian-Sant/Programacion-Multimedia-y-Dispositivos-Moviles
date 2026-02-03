package com.example.practica5_materialdesign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class Fragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_2, container, false);

        EditText cuenta = root.findViewById(R.id.cuenta);
        CheckBox propinaCheck = root.findViewById(R.id.propina);
        TextView porcentajePropinaTexto = root.findViewById(R.id.porcentajePropina);
        SeekBar porcentaje = root.findViewById(R.id.porcentaje);
        RadioGroup radioGroupPago = root.findViewById(R.id.radioGroupPago);
        RatingBar calificacion = root.findViewById(R.id.calificacion);
        Button calcular = root.findViewById(R.id.calcular);
        TextView calculo = root.findViewById(R.id.calculo);
        AutoCompleteTextView camarero = root.findViewById(R.id.camarero);

        porcentajePropinaTexto.setVisibility(TextView.GONE);
        porcentaje.setVisibility(SeekBar.GONE);

        String[] camareros = {"Carlos","Laura","Miguel","Ana","Javier","Sofía","Andrés"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                camareros
        );
        camarero.setAdapter(adapter);

        propinaCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    porcentaje.setProgress(10);
                    porcentajePropinaTexto.setVisibility(TextView.VISIBLE);
                    porcentaje.setVisibility(SeekBar.VISIBLE);
                    porcentajePropinaTexto.setText(
                            getString(R.string.porcentaje) + porcentaje.getProgress() + "%"
                    );
                } else {
                    porcentaje.setProgress(0);
                    porcentajePropinaTexto.setVisibility(TextView.GONE);
                    porcentaje.setVisibility(SeekBar.GONE);
                }
            }
        });

        porcentaje.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentajePropinaTexto.setText(
                        getString(R.string.porcentaje) + progress + "%"
                );
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        final String[] metodoPago = new String[1];
        radioGroupPago.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = root.findViewById(checkedId);
                if (rb != null) {
                    metodoPago[0] = rb.getText().toString();
                }
            }
        });

        final double[] calificacionServicio = new double[1];
        calificacion.setRating(5);
        calificacionServicio[0] = 5;

        calificacion.setOnRatingBarChangeListener(
                (ratingBar, rating, fromUser) -> calificacionServicio[0] = rating
        );

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (camarero.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), R.string.nombreCamarero, Toast.LENGTH_SHORT).show();
                    return;
                }

                if (cuenta.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), R.string.valor, Toast.LENGTH_SHORT).show();
                    return;
                }

                if (radioGroupPago.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getContext(), R.string.metodo, Toast.LENGTH_SHORT).show();
                    return;
                }

                double cuentaValor = Double.parseDouble(cuenta.getText().toString());
                double propina = cuentaValor * porcentaje.getProgress() / 100.0;
                double total = cuentaValor + propina;

                calculo.setText(
                        getString(R.string.atendido) + camarero.getText().toString() +
                                getString(R.string.cuenta) + cuentaValor + "€" +
                                getString(R.string.propinaTexto) + propina + "€" +
                                getString(R.string.totalTexto) + total + "€" +
                                getString(R.string.metodoDePago) + metodoPago[0] +
                                getString(R.string.calificacionServicio) + calificacionServicio[0]
                );

                // Snackbar heredado del Fragment2
                Snackbar.make(view, "Cuenta calculada correctamente", Snackbar.LENGTH_LONG).show();
            }
        });

        return root;
    }
}
