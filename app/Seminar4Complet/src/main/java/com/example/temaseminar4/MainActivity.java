package com.example.temaseminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ADAUGARE = 1;

    private List<Cinema> CinemaList;
    private TextView tvRezultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CinemaList = new ArrayList<>();

        tvRezultat = findViewById(R.id.tvRezultat);
    }

    public void deschideAdaugare(View view) {
        Intent intent = new Intent(MainActivity.this, AdaugareCinema.class);
        startActivityForResult(intent, REQUEST_ADAUGARE);
    }

    public void deschideAdaugareAI(View view) {
        Intent intent = new Intent(MainActivity.this, AdaugareCinemaAI.class);
        startActivityForResult(intent, REQUEST_ADAUGARE);
    }

    public void afiseazaListViewCinematografe(View view) {
        Intent intent = new Intent(MainActivity.this, afisareCinematografe.class);
        intent.putExtra("Cinemas", new ArrayList<>(CinemaList));
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ADAUGARE && resultCode == RESULT_OK && data != null) {
            Cinema cinema = (Cinema) data.getSerializableExtra("cinema");

            if (cinema != null) {
                CinemaList.add(new Cinema(cinema.getNume(), cinema.getGen(), cinema.getTipSala(), cinema.isParcare(), cinema.isAre3D(), cinema.getRating()));
                tvRezultat.setText(cinema.toString());
                Toast.makeText(this, "Cinematograf adaugat: " + cinema.getNume(),
                        Toast.LENGTH_LONG).show();
            }
        }
    }

}