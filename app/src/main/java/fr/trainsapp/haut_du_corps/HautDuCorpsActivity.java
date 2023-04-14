package fr.trainsapp.haut_du_corps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import fr.trainsapp.complet.CompletActivity;
import fr.trainsapp.MainActivity;
import fr.trainsapp.ProfilActivity;
import fr.trainsapp.R;
import fr.trainsapp.abdominaux.AbdominauxActivity;
import fr.trainsapp.bas_du_corps.BasDuCorpsActivity;

public class HautDuCorpsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haut_du_corps);

        ImageView logo = findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HautDuCorpsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Bouton vers la page Fighter Power
        Button button_v_fighter_power = (Button) findViewById(R.id.button_v_fighter_power);
        button_v_fighter_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fighter_power = new Intent(HautDuCorpsActivity.this, FighterPowerActivity.class);
                startActivity(fighter_power);
            }
        });

        // Bouton vers la page Destroy Your Arms
        Button button_v_destroy_your_arms = (Button) findViewById(R.id.button_v_destroy_your_arms);
        button_v_destroy_your_arms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent destroy_your_arms = new Intent(HautDuCorpsActivity.this, DestroyYourArmsActivity.class);
                startActivity(destroy_your_arms);
            }
        });

        // Bouton vers la page Fight Your Limits
        Button button_v_fight_your_limits = (Button) findViewById(R.id.button_v_fight_your_limits);
        button_v_fight_your_limits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fight_your_limits = new Intent(HautDuCorpsActivity.this, FightYourLimitsActivity.class);
                startActivity(fight_your_limits);
            }
        });

        // Bouton vers la page Dumbells Power
        Button button_v_dumbells_power = (Button) findViewById(R.id.button_v_dumbells_power);
        button_v_dumbells_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dumbells_power = new Intent(HautDuCorpsActivity.this, DumbellsPowerActivity.class);
                startActivity(dumbells_power);
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