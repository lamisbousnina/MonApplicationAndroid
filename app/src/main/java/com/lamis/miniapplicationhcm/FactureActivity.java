package com.lamis.miniapplicationhcm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FactureActivity extends AppCompatActivity {

    private TextView factureNumber, productType, paymentType, amount, invoiceDate, commissionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityfacture2);

        // Initialisation des vues
        factureNumber = findViewById(R.id.facture_number);
        productType = findViewById(R.id.product_type);
        paymentType = findViewById(R.id.payment_type);
        amount = findViewById(R.id.amount);
        invoiceDate = findViewById(R.id.invoice_date);
        commissionTextView = findViewById(R.id.commission);

        // Récupérer les données envoyées par Detail2Activity
        Intent intent = getIntent();
        String factureNum = intent.getStringExtra("facture_number");
        String product = intent.getStringExtra("product_type");
        String payment = intent.getStringExtra("payment_type");
        String paymentAmount = intent.getStringExtra("amount");
        String date = intent.getStringExtra("invoice_date");

        // Convertir le montant en nombre pour calculer la commission
        double montant = Double.parseDouble(paymentAmount.replace(" DT", "").trim());
        double commission = calculerCommission(montant);

        // Afficher les données dans les TextViews
        factureNumber.setText("Numéro de Facture: " + factureNum);
        productType.setText("Produit: " + product);
        paymentType.setText("Type de Paiement: " + payment);
        amount.setText("Montant à Payer: " + paymentAmount);
        invoiceDate.setText("Date de Facture: " + date);

        // Afficher la commission
        commissionTextView.setText("Commission: " + String.format("%.2f", commission) + " DT");
    }

    /**
     * Méthode pour calculer la commission en fonction des règles.
     */
    private double calculerCommission(double montant) {
        if (montant < 300) {
            return montant * 0.05;
        } else if (montant >= 300 && montant <= 500) {
            return montant * 0.10;
        } else if (montant > 500 && montant <= 700) {
            return montant * 0.15;
        } else { // montant > 700
            return montant * 0.20;
        }
    }
}
