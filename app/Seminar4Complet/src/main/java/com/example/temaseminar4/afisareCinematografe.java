package com.example.temaseminar4;
import android.widget.Toast;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class afisareCinematografe extends AppCompatActivity {

    private List<Cinema> cinemaList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_afisare_cinematografe);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cinemaList = (ArrayList<Cinema>)getIntent().getSerializableExtra("Cinemas");

        if (cinemaList == null) {
            cinemaList = new ArrayList<>();
        }

        ArrayAdapter<Cinema> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                cinemaList
        );

        ListView lv = findViewById(R.id.lvCinemas);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            Cinema cinemaSelectat = cinemaList.get(position);
            Toast.makeText(afisareCinematografe.this, cinemaSelectat.toString(), Toast.LENGTH_LONG).show();
        });

        lv.setOnItemLongClickListener((parent, view, position, id) -> {
            Cinema cinemaSters = cinemaList.get(position);
            cinemaList.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(afisareCinematografe.this, "A fost sters: " + cinemaSters.getNume(), Toast.LENGTH_SHORT).show();
            return true;
        });

    }
}