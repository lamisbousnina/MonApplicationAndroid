package com.lamis.miniapplicationhcm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private ImageView imgDetail;
    private TextView tvDetailTitle, propertyDetails, tvDetailPrice;
    private Button btnBookNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail); // Assure-toi que ce layout existe

        // Initialisation des vues
        imgDetail = findViewById(R.id.imgDetail);
        tvDetailTitle = findViewById(R.id.tvDetailTitle);
        propertyDetails = findViewById(R.id.property_details);
        tvDetailPrice = findViewById(R.id.tvDetailPrice);
        btnBookNow = findViewById(R.id.btnBookNow);

        // Récupérer les données envoyées par MainActivity
        String address = getIntent().getStringExtra("address");
        String location = getIntent().getStringExtra("location");
        String details = getIntent().getStringExtra("details");
        String price = getIntent().getStringExtra("price");
        int imageResId = getIntent().getIntExtra("imageResId", 0);

        // Affichage des données dans les vues
        imgDetail.setImageResource(imageResId); // Image de la propriété
        tvDetailTitle.setText(address); // Titre de la propriété (adresse)
        propertyDetails.setText(details); // Détails de la propriété
        tvDetailPrice.setText(price); // Prix de la propriété

        // Event listener pour le bouton (si tu souhaites gérer une action comme réserver)
        btnBookNow.setOnClickListener(v -> {
            // Créer l'intention pour naviguer vers FactureActivity
            Intent intent = new Intent(DetailActivity.this, FactureActivity1.class);

            // Passer des données à FactureActivity
            intent.putExtra("address", address);
            intent.putExtra("price", price);
            intent.putExtra("productType", "Appartement");
            intent.putExtra("paymentType", "Louer");

            // Démarrer FactureActivity
            startActivity(intent);
        });
    }
}
