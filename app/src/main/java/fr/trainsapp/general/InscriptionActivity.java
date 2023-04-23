package fr.trainsapp.general;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import fr.trainsapp.R;

public class InscriptionActivity extends AppCompatActivity {

    FirebaseDatabase utilisateurs_db; // Fait la connection avec FireBase
    DatabaseReference ref_utilisateurs_db; // Lie et écris dans la bdd

    private String sNom;
    private String sPrenom;
    private String sPseudo;
    private String sMail;
    private String sMdp;

    private EditText nom;
    private EditText prenom;
    private EditText pseudo;
    private EditText mail;
    private EditText mdp;
    private Button soumettre;

    // Instancie SharedPreference
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        utilisateurs_db = FirebaseDatabase.getInstance();
        ref_utilisateurs_db = utilisateurs_db.getReference("trains");

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        pseudo = findViewById(R.id.pseudo);
        mail = findViewById(R.id.mail);
        mdp = findViewById(R.id.mdp);
        soumettre = findViewById(R.id.soumettre);

        sharedPreferences = getSharedPreferences("info", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        soumettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quand on clique sur le bouton je récupére les données des editText
                sNom = nom.getText().toString();
                sPrenom = prenom.getText().toString();
                sPseudo = pseudo.getText().toString();
                sMail = mail.getText().toString();
                sMdp = mdp.getText().toString();

                //vérification du formulaire
                if(verif()){
                    //on crée une nouvelle instance de la class User pour réunir tout les paramtères
                    Users newUser = new Users(sNom, sPrenom, sPseudo, sMail, sMdp);
                    // On crée une table (si n'xiste pas, sinon se connecte), écris la clé(mail), insert dans la bdd
                    ref_utilisateurs_db.child("utilisateur").child(newUser.getsPseudo()).setValue(newUser);
                    Toast.makeText(v.getContext(), "Inscription effectuée", Toast.LENGTH_LONG).show();

                    // Enregistrer les informations dans SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("cle_nom", sNom);
                    editor.putString("cle_prenom", sPrenom);
                    editor.putString("cle_pseudo", sPseudo);
                    editor.putString("cle_mail", sMail);
                    editor.apply();

                    Intent intent = new Intent(InscriptionActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(v.getContext(), "Veuillez renseigner tous les champs", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean verif(){
        boolean resultat = true;
        if (sNom.equals("")){
            resultat = false;
        }
        else if(sPrenom.equals("")){
            resultat = false;
        }
        else if(sPseudo.equals("")){
            resultat = false;
        }
        else if(sMail.equals("")){
            resultat = false;
        }
        else if(sMdp.equals("")){
            resultat = false;
        }
        return resultat;
    }
}
