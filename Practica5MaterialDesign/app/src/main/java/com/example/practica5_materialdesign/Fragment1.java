package com.example.practica5_materialdesign;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.snackbar.Snackbar;

public class Fragment1 extends Fragment {

    private TextInputLayout tilName;
    private TextInputEditText etName;
    private Button btnSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_1, container, false);

        tilName = root.findViewById(R.id.til_name);
        etName = root.findViewById(R.id.et_name);
        btnSubmit = root.findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            if (TextUtils.isEmpty(name)) {
                tilName.setError("El campo no puede estar vacío");
            } else {
                tilName.setError(null);
                Snackbar.make(v, "¡Hola " + name + "!", Snackbar.LENGTH_LONG).show();
            }
        });

        return root;
    }
    public void limpiarNombre() {
        if (tilName != null && tilName.getEditText() != null) {
            tilName.getEditText().setText("");
        }
    }
}