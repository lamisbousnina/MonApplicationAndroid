package com.lamis.miniapplicationhcm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LouerActivity extends AppCompatActivity {

    private LinearLayout propertyListLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_louer);

        propertyListLayout = findViewById(R.id.property_list);

        // Annonce 1 : Propriété à louer
        Button moreDetailsButton1 = findViewById(R.id.more_details_button11);
        moreDetailsButton1.setOnClickListener(view -> {
            // Passer les détails de la propriété à l'activité de détail
            Intent intent = new Intent(LouerActivity.this, DetailActivity.class);
            intent.putExtra("address", "Appartement S+1");
            intent.putExtra("location", "Aouina");
            intent.putExtra("details", "S+1, 1 salle de bains");
            intent.putExtra("price", "À partir de 800 DT/mois");
            intent.putExtra("imageResId", R.drawable.louer1); // Image pour cette propriété à louer
            startActivity(intent);
        });

        // Annonce 2 : Propriété à louer
        Button moreDetailsButton2 = findViewById(R.id.more_details_button22);
        moreDetailsButton2.setOnClickListener(view -> {
            // Passer les détails de la propriété à l'activité de détail
            Intent intent = new Intent(LouerActivity.this, DetailActivity.class);
            intent.putExtra("address", "Mini Villa #201");
            intent.putExtra("location", "Marsa");
            intent.putExtra("details", "4 chambres, 2.5 salles de bains, 1 garage, piscine");
            intent.putExtra("price", "À partir de 1000 DT/mois");
            intent.putExtra("imageResId", R.drawable.louer2); // Image pour cette propriété à louer
            startActivity(intent);
        });

        // Annonce 3 : Propriété à louer
        Button moreDetailsButton3 = findViewById(R.id.more_details_button33);
        moreDetailsButton3.setOnClickListener(view -> {
            // Passer les détails de la propriété à l'activité de détail
            Intent intent = new Intent(LouerActivity.this, Detail2Activity.class);
            intent.putExtra("address", "Appartement S+2 #101");
            intent.putExtra("location", "Rades");
            intent.putExtra("details", "S+2, 1 salle de bains");
            intent.putExtra("price", "À partir de 600 DT/mois");
            intent.putExtra("imageResId", R.drawable.louer3); // Image pour cette propriété à louer
            startActivity(intent);
        });
    }
}
