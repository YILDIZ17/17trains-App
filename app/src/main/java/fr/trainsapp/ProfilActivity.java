package fr.trainsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import fr.trainsapp.abdominaux.AbdominauxActivity;
import fr.trainsapp.bas_du_corps.BasDuCorpsActivity;
import fr.trainsapp.complet.CompletActivity;
import fr.trainsapp.general.AccueilActivity;
import fr.trainsapp.general.InscriptionActivity;
import fr.trainsapp.general.MainActivity;
import fr.trainsapp.haut_du_corps.HautDuCorpsActivity;

public class ProfilActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    private TextView nomTextView;
    private TextView prenomTextView;
    private TextView pseudoTextView;
    private TextView mailTextView;
    private Button deconnexionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        sharedPreferences = getSharedPreferences("info", MODE_PRIVATE);

        ImageView logo = findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        deconnexionButton = findViewById(R.id.button);
        deconnexionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Retourner à la page d'accueil
                Intent intent = new Intent(ProfilActivity.this, AccueilActivity.class);
                startActivity(intent);
                finish(); // Ferme l'activité pour ne pas pouvoir y retourner avec le bouton "Retour"
            }
        });

        // Récupérer les TextViews du layout XML
        nomTextView = findViewById(R.id.nom);
        prenomTextView = findViewById(R.id.prenom);
        pseudoTextView = findViewById(R.id.pseudo);
        mailTextView = findViewById(R.id.mail);

        // Récupérer les informations de l'utilisateur de la page précédente (InscriptionActivity)
        Intent intent = getIntent();
        String nom = intent.getStringExtra("cle_nom");
        String prenom = intent.getStringExtra("cle_prenom");
        String pseudo = intent.getStringExtra("cle_pseudo");
        String mail = intent.getStringExtra("cle_mail");

        // Afficher les informations de l'utilisateur dans les TextViews correspondants
        nomTextView.setText("Nom: " + nom);
        prenomTextView.setText("Prénom: " + prenom);
        pseudoTextView.setText("Pseudo: " + pseudo);
        mailTextView.setText("Mail: " + mail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_accueil:
                Intent accueil = new Intent(this, MainActivity.class);
                startActivity(accueil);
                return true;
            case R.id.menu_bas_du_corps:
                Intent bas_du_corps = new Intent(this, BasDuCorpsActivity.class);
                startActivity(bas_du_corps);
                return true;
            case R.id.menu_abdominaux:
                Intent abdominaux = new Intent(this, AbdominauxActivity.class);
                startActivity(abdominaux);
                return true;
            case R.id.menu_haut_du_corps:
                Intent haut_du_corps = new Intent(this, HautDuCorpsActivity.class);
                startActivity(haut_du_corps);
                return true;
            case R.id.menu_complet:
                Intent complet = new Intent(this, CompletActivity.class);
                startActivity(complet);
                return true;
            case R.id.menu_profil:
                Intent profil = new Intent(this, ProfilActivity.class);
                startActivity(profil);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
