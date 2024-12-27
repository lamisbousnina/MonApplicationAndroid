package com.lamis.miniapplicationhcm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail2Activity extends AppCompatActivity {

    private ImageView imgDetail;
    private TextView tvDetailTitle, propertyDetails, tvDetailPrice;
    private Button btnBookNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_louer); // Assure-toi que ce layout existe

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

        // Event listener pour le bouton "Réserver maintenant"
        btnBookNow.setOnClickListener(v -> {
            // Créer un Intent pour rediriger vers la FactureActivity
            Intent intent = new Intent(Detail2Activity.this, FactureActivity.class);

            // Passer les données de la propriété à la FactureActivity
            intent.putExtra("facture_number", "#12345"); // Exemple de numéro de facture
            intent.putExtra("product_type", "Appartement"); // Type de produit
            intent.putExtra("payment_type", "Location"); // Type de paiement
            intent.putExtra("amount", price); // Montant de la facture
            intent.putExtra("invoice_date", "17/12/2024"); // Date de la facture

            // Démarrer l'activité FactureActivity
            startActivity(intent);
        });
    }
}
