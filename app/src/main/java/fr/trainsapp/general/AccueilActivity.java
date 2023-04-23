package fr.trainsapp.general;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.trainsapp.R;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        Button button_inscription = (Button) findViewById(R.id.button_inscription);
        button_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inscription = new Intent(AccueilActivity.this, InscriptionActivity.class);
                startActivity(inscription);
            }
        });

        Button button_connexion = (Button) findViewById(R.id.button_connexion);
        button_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connexion = new Intent(AccueilActivity.this, ConnexionActivity.class);
                startActivity(connexion);
            }
        });
    }
}