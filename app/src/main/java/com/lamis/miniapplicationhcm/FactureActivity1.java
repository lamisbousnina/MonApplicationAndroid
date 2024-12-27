package com.lamis.miniapplicationhcm;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FactureActivity1 extends AppCompatActivity {

    private TextView tvFactureNumber, tvProductType, tvPaymentType, tvAmount, tvInvoiceDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facture); // Assure-toi que ce layout existe

        // Initialisation des vues
        tvFactureNumber = findViewById(R.id.facture_number);
        tvProductType = findViewById(R.id.product_type);
        tvPaymentType = findViewById(R.id.payment_type);
        tvAmount = findViewById(R.id.amount);
        tvInvoiceDate = findViewById(R.id.invoice_date);

        // Récupérer les données envoyées par la DetailActivity
        String address = getIntent().getStringExtra("address");
        String price = getIntent().getStringExtra("price");
        String productType = getIntent().getStringExtra("productType");
        String paymentType = getIntent().getStringExtra("paymentType");

        // Affichage des données dans les TextViews
        tvFactureNumber.setText("Facture #" + (int)(Math.random() * 10000)); // Numéro de facture aléatoire
        tvProductType.setText("Produit: " + productType);
        tvPaymentType.setText("Type de Paiement: " + paymentType);
        tvAmount.setText("Montant à Payer: " + price);
        tvInvoiceDate.setText("Date de Facture: " + java.time.LocalDate.now().toString()); // Date actuelle
    }
}
