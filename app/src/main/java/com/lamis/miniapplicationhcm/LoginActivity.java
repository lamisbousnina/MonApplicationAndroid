package com.lamis.miniapplicationhcm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//Declaration
public class LoginActivity extends AppCompatActivity {
    private EditText etLogin, etPassword;//var
    private Button btnConnect;
    private TextView registerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//initialise le l"interace xml
        setContentView(R.layout.activity_login); // Utiliser activity_login.xml ici

        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        btnConnect = findViewById(R.id.btnConnect);
        registerText = findViewById(R.id.registerText);

        // Lorsque le bouton de connexion est cliqué
        btnConnect.setOnClickListener(view -> {
            String login = etLogin.getText().toString();
            String password = etPassword.getText().toString();

            if (login.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Logique d'authentification ici
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                // Naviguer vers MainActivity après connexion réussie
                startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
                finish(); // Terminer l'activité de connexion
            }
        });

        // Lorsque le texte "registerText" est cliqué, rediriger vers l'activité d'inscription
        registerText.setOnClickListener(view -> {
            // Naviguer vers l'activité d'inscription
            startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
        });
    }
}
