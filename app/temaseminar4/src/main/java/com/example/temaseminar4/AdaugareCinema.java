package com.example.temaseminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugareCinema extends AppCompatActivity {

    private EditText etNume;
    private Spinner spinnerGen;
    private RadioButton rbImax;
    private CheckBox cbParcare;
    private Switch swAre3D;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adaugare_cinema);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNume = findViewById(R.id.etNume);
        spinnerGen = findViewById(R.id.spinnerGen);
        rbImax = findViewById(R.id.rbImax);
        cbParcare = findViewById(R.id.cbParcare);
        swAre3D = findViewById(R.id.swAre3D);
        ratingBar = findViewById(R.id.ratingBar);
    }

    public void salveaza(View view) {
        String nume = etNume.getText().toString().trim();

        if (nume.isEmpty()) {
            etNume.setError("Introdu numele cinematografului");
            return;
        }

        String gen = spinnerGen.getSelectedItem().toString();
        String tipSala = rbImax.isChecked() ? "IMAX" : "Standard";
        boolean parcare = cbParcare.isChecked();
        boolean are3D = swAre3D.isChecked();
        float rating = ratingBar.getRating();

        Cinema cinema = new Cinema(nume, gen, tipSala, parcare, are3D, rating);

        Intent intent = new Intent();
        intent.putExtra("cinema", cinema);
        setResult(RESULT_OK, intent);
        finish();
    }
}