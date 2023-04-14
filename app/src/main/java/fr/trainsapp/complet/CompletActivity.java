package fr.trainsapp.complet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import fr.trainsapp.MainActivity;
import fr.trainsapp.ProfilActivity;
import fr.trainsapp.R;
import fr.trainsapp.abdominaux.AbdominauxActivity;
import fr.trainsapp.bas_du_corps.BasDuCorpsActivity;
import fr.trainsapp.haut_du_corps.HautDuCorpsActivity;

public class CompletActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complet);

        ImageView logo = findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompletActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Bouton vers la page Build Your Endurance
        Button button_v_build_your_endurance = (Button) findViewById(R.id.button_v_build_your_endurance);
        button_v_build_your_endurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent build_your_endurance = new Intent(CompletActivity.this, BuildYourEnduranceActivity.class);
                startActivity(build_your_endurance);
            }
        });

        // Bouton vers la page Work Hard
        Button button_v_work_hard = (Button) findViewById(R.id.button_v_work_hard);
        button_v_work_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent work_hard = new Intent(CompletActivity.this, WorkHardActivity.class);
                startActivity(work_hard);
            }
        });

        // Bouton vers la page Home Training
        Button button_v_home_training = (Button) findViewById(R.id.button_v_home_training);
        button_v_home_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home_training = new Intent(CompletActivity.this, HomeTrainingActivity.class);
                startActivity(home_training);
            }
        });

        // Bouton vers la page Street Workout
        Button button_v_street_workout = (Button) findViewById(R.id.button_v_street_workout);
        button_v_street_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent street_workout = new Intent(CompletActivity.this, StreetWorkoutActivity.class);
                startActivity(street_workout);
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