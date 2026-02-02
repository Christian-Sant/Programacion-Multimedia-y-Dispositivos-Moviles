package com.example.practica5_materialdesign;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.snackbar.Snackbar;

public class Fragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_2, container, false);

        // Botón dentro del fragment para mostrar un Snackbar
        root.findViewById(R.id.btn_fragment2).setOnClickListener(v ->
                Snackbar.make(v, "¡Botón del Fragment 2 pulsado!", Snackbar.LENGTH_LONG).show()
        );

        return root;
    }
}
