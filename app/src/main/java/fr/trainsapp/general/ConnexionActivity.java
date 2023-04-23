package fr.trainsapp.general;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import fr.trainsapp.R;

public class ConnexionActivity extends AppCompatActivity {

    private EditText pseudo;
    private EditText mdp;
    private Button soumettre;

    private String sPseudo;
    private String sMdp;

    static Context sContext;

    FirebaseDatabase utilisateurs_db; // Fait la connexion avec FireBase
    DatabaseReference ref_utilisateurs_db; // Lie et écris dans la bdd

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        sContext = this;

        utilisateurs_db = FirebaseDatabase.getInstance();
        ref_utilisateurs_db = utilisateurs_db.getReference("trains");

        pseudo = findViewById(R.id.pseudo_connexion);
        mdp = findViewById(R.id.mdp_connexion);
        soumettre = findViewById(R.id.soumettre_connexion);

        soumettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPseudo = pseudo.getText().toString();
                sMdp = mdp.getText().toString();

                if(verif() == true){
                    //on crée une nouvelle instance de la class User pour réunir tout les paramtères
                    //Users newUser = new Users(sPseudo, sMdp);
                    // On crée une table (si n'xiste pas, sinon se connecte), écris la clé(mail), insert dans la bdd
                    ref_utilisateurs_db.child("utilisateur").child(sPseudo).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot == null){
                                Toast.makeText(sContext, "L'utilisateur n'existe pas", Toast.LENGTH_LONG).show();
                            }
                            else{
                                Users users = snapshot.getValue(Users.class);
                                if(users.getsMdp().equals(sMdp)){
                                    Toast.makeText(sContext, "Bienvenue", Toast.LENGTH_LONG).show();
                                    Intent connexion = new Intent(ConnexionActivity.this, MainActivity.class);
                                    startActivity(connexion);
                                }
                                else{
                                    Toast.makeText(sContext, "L'utilisateur n'existe pas", Toast.LENGTH_LONG).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else{
                    Toast.makeText(v.getContext(), "Veuillez renseigner tous les champs", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean verif(){

        boolean resultat = true;
        if(sPseudo.equals("")){
            resultat = false;
        }
        else if(sMdp.equals("")){
            resultat = false;
        }
        return resultat;
    }
}