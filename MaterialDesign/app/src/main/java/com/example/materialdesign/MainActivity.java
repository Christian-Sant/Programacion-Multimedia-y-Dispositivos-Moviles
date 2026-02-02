package com.example.materialdesign;

import static android.app.ProgressDialog.show;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.materialdesign.databinding.ActivityMainBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l3);

        // Configure the click listener of the button
        Button showSnackbarButton = findViewById(R.id.showSnackbarButton);
// Configurar el click listener del botón
        showSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// Mostrar un Snackbar con una acción
                Snackbar.make(v, "This is a Snackbar!", Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
// Acción al presionar "UNDO"
                        Snackbar.make(v, "Action undone", Snackbar.LENGTH_SHORT).show();
                    }
                })
                .show();
            }
        });

        /*TextView textView = findViewById(R.id.textView);
        FloatingActionButton fab = findViewById(R.id.fab);

        // Configuración del click listener del FAB
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al presionar el botón
                textView.setText("Floating Action Button Clicked!");
                Toast.makeText(MainActivity.this, "FAB Pressed!", Toast.LENGTH_SHORT).show();
            }
        });
        /*binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });*/
        // Referencias al TextInputLayout y TextInputEditText
        /*TextInputLayout emailLayout = findViewById(R.id.emailLayout);
        TextInputEditText emailEditText = findViewById(R.id.emailEditText);
        Button validateButton = findViewById(R.id.validateButton);*/

        // Listener para el botón de validación
        /*validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();

                if (email.isEmpty()) {
                    emailLayout.setError("Email cannot be empty");
                } else if (!isValidEmail(email)) {
                    emailLayout.setError("Invalid email address");
                } else {
                    emailLayout.setError(null); // Clear the error
                    Toast.makeText(MainActivity.this, "Valid email!", Toast.LENGTH_SHORT).show();
                    // Optionally, perform further actions if the email is valid
                    // For example, display a success message or proceed to the next step
                }
            }
        });

        // Clear error on text change
        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailLayout.setError(null); // Clear the error when text changes
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });*/
    }

    // Método para validar el formato del correo electrónico
    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}