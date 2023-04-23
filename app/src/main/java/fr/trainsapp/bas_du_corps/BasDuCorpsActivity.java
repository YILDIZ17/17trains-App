package fr.trainsapp.bas_du_corps;

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
import fr.trainsapp.abdominaux.AbdominauxActivity;
import fr.trainsapp.complet.CompletActivity;
import fr.trainsapp.haut_du_corps.HautDuCorpsActivity;
import fr.trainsapp.general.MainActivity;
import fr.trainsapp.R;

public class BasDuCorpsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bas_du_corps);

        ImageView logo = findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasDuCorpsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Boutton vers la page Steel Legs
        Button button_v_steel_legs = (Button) findViewById(R.id.button_v_steel_legs);
        button_v_steel_legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent steel_legs = new Intent(BasDuCorpsActivity.this, SteelLegsActivity.class);
                startActivity(steel_legs);
            }
        });

        // Boutton vers la page Level Up
        Button button_v_level_up = (Button) findViewById(R.id.button_v_level_up);
        button_v_level_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent level_up = new Intent(BasDuCorpsActivity.this, LevepUpActivity.class);
                startActivity(level_up);
            }
        });

        // Boutton vers la page 30'S Fighters
        Button button_v_fighters = (Button) findViewById(R.id.button_v_fighters);
        button_v_fighters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fighters = new Intent(BasDuCorpsActivity.this, FightersActivity.class);
                startActivity(fighters);
            }
        });

        // Boutton vers la page Pré-Training
        Button button_v_pre_training = (Button) findViewById(R.id.button_v_pre_training);
        button_v_pre_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pre_training = new Intent(BasDuCorpsActivity.this, PreTrainingActivity.class);
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