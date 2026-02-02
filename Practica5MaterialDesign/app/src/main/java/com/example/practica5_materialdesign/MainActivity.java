package com.example.practica5_materialdesign;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);


        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        // Opcional: agregar iconos a los tabs
        tabs.getTabAt(0).setIcon(R.drawable.ic_launcher_foreground);
        tabs.getTabAt(1).setIcon(R.drawable.ic_launcher_foreground);
        tabs.getTabAt(2).setIcon(R.drawable.ic_launcher_foreground);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view ->
                Snackbar.make(view, "Nombre guardada", Snackbar.LENGTH_LONG)
                        .setAction("Deshacer", v -> {
                            Fragment1 f1 = sectionsPagerAdapter.getFragment1();
                            if (f1 != null) {
                                f1.limpiarNombre();
                            }
                        }).show()
        );
    }
}