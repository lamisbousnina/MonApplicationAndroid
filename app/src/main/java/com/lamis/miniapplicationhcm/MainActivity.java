package com.lamis.miniapplicationhcm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout propertyListLayout;
//methode oncreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        propertyListLayout = findViewById(R.id.property_list);
//ajout des prop dyna
        addProperty("1045 N Kings Rd #101", "Los Angeles, CA", "3 Beds, 2.5 Baths", "$869,000", R.drawable.house1);
        addProperty("447 N Doheny Dr #201", "West Hollywood, CA", "4 Beds, 2.5 Baths", "$769,000", R.drawable.house2);
        addProperty("1414 N Fairfax Ave #101", "Los Angeles, CA", "4 Beds, 3.5 Baths", "$625,000", R.drawable.house3);
        addProperty("1253 N Sweetzer Ave #4", "West Hollywood, CA", "3 Beds, 2.5 Baths", "$1,199,000", R.drawable.house4);
        addProperty("1234 Sunset Blvd #505", "Los Angeles, CA", "2 Beds, 2 Baths", "$850,000", R.drawable.house5);
        addProperty("789 Palm Dr #8", "Los Angeles, CA", "2 Beds, 1 Bath", "$590,000", R.drawable.house6);

        // Ajouter la gestion du clic du bouton jaune
        Button btnYellow = findViewById(R.id.more_details_button1);
        btnYellow.setOnClickListener(v -> {
            // Lancer DetailActivity lorsqu'on clique sur le bouton jaune
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            // Ajoute les informations nécessaires dans l'intention (par exemple, ici l'adresse, etc.)
            intent.putExtra("address", "1045 N Kings Rd #101");
            intent.putExtra("location", "Los Angeles, CA");
            intent.putExtra("details", "3 Beds, 2.5 Baths");
            intent.putExtra("price", "$869,000");
            intent.putExtra("imageResId", R.drawable.house1);
            startActivity(intent);
        });
    }
//methode addprp
    private void addProperty(String address, String location, String details, String price, int imageResId) {
        CardView propertyCard = new CardView(this);
        propertyCard.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        propertyCard.setCardElevation(4f);
        propertyCard.setRadius(8f);

        LinearLayout propertyLayout = new LinearLayout(this);
        propertyLayout.setOrientation(LinearLayout.HORIZONTAL);
        propertyLayout.setPadding(8, 8, 8, 8);

        ImageView propertyImage = new ImageView(this);
        propertyImage.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
        propertyImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        propertyImage.setImageResource(imageResId);

        // Rendre l'image cliquable
        propertyImage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("address", address);
            intent.putExtra("location", location);
            intent.putExtra("details", details);
            intent.putExtra("price", price);
            intent.putExtra("imageResId", imageResId);
            startActivity(intent);
        });

        LinearLayout textLayout = new LinearLayout(this);
        textLayout.setOrientation(LinearLayout.VERTICAL);
        textLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
        textLayout.setPadding(8, 8, 8, 8);

        TextView addressText = new TextView(this);
        addressText.setText(address);
        addressText.setTextSize(14f);
        addressText.setTextColor(getResources().getColor(android.R.color.black));

        TextView locationText = new TextView(this);
        locationText.setText(location);
        locationText.setTextSize(12f);
        locationText.setTextColor(getResources().getColor(android.R.color.darker_gray));

        TextView detailsText = new TextView(this);
        detailsText.setText(details);
        detailsText.setTextSize(12f);
        detailsText.setTextColor(getResources().getColor(android.R.color.black));

        TextView priceText = new TextView(this);
        priceText.setText(price);
        priceText.setTextSize(14f);
        priceText.setTextColor(getResources().getColor(R.color.teal_700));

        textLayout.addView(addressText);
        textLayout.addView(locationText);
        textLayout.addView(detailsText);
        textLayout.addView(priceText);

        propertyLayout.addView(propertyImage);
        propertyLayout.addView(textLayout);
        propertyCard.addView(propertyLayout);

        propertyListLayout.addView(propertyCard);
    }
}
