package com.lamis.miniapplicationhcm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.lamis.miniapplicationhcm.MainActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        // Récupération des boutons
        Button btnAcheter = findViewById(R.id.btnAcheter);
        Button btnLouer = findViewById(R.id.btnLouer);

        // Action pour le bouton "Acheter"
        btnAcheter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Naviguer vers MainActivity
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Action pour le bouton "Louer"
        btnLouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Naviguer vers MainActivity
                Intent intent = new Intent(WelcomeActivity.this, LouerActivity.class);
                startActivity(intent);
            }
        });
    }
}
