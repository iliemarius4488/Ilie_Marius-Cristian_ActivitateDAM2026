package com.example.ilie_marius_cristian_activitatedam2026;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void onClick(View view) {
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("mesaj", "Mesaj din prima activiitate");
        bundle.putInt("numar1", 5);
        bundle.putInt("numar2", 7);
        intent.putExtras(bundle);
        startActivityForResult(intent, 70);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==70)
        {
            if(resultCode==RESULT_OK)
            {
                String mesaj = data.getStringExtra("mesaj");
                int suma=data.getIntExtra("suma", 0);
                StringBuilder builder = new StringBuilder(mesaj);
                builder.append(" ").append(suma);
                Toast.makeText(this, builder.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}