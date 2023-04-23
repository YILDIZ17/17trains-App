package fr.trainsapp.abdominaux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import fr.trainsapp.ProfilActivity;
import fr.trainsapp.complet.CompletActivity;
import fr.trainsapp.haut_du_corps.HautDuCorpsActivity;
import fr.trainsapp.general.MainActivity;
import fr.trainsapp.R;
import fr.trainsapp.bas_du_corps.BasDuCorpsActivity;

public class AbdominauxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abdominaux);

        ImageView logo = findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbdominauxActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Boutton vers la page Destructor
        Button button_v_destructor = (Button) findViewById(R.id.button_v_destructor);
        button_v_destructor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent destructor = new Intent(AbdominauxActivity.this, DestructorActivity.class);
                startActivity(destructor);
            }
        });

        // Boutton vers la page Ab'Training
        Button button_v_ab_training = (Button) findViewById(R.id.button_v_ab_training);
        button_v_ab_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ab_training = new Intent(AbdominauxActivity.this, AbTrainActivity.class);
                startActivity(ab_training);
            }
        });

        // Boutton vers la page Build Your Abs
        Button button_v_build_your_abs = (Button) findViewById(R.id.button_v_build_your_abs);
        button_v_build_your_abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fighters = new Intent(AbdominauxActivity.this, BuildYourAbsActivity.class);
                startActivity(fighters);
            }
        });

        // Boutton vers la page Fire Plank
        Button button_v_fire_plank = (Button) findViewById(R.id.button_v_fire_plank);
        button_v_fire_plank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pre_training = new Intent(AbdominauxActivity.this, FirePlankActivity.class);
                startActivity(pre_training);
            }
        });
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