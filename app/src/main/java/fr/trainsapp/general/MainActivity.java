package fr.trainsapp.general;

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
import fr.trainsapp.R;
import fr.trainsapp.abdominaux.AbdominauxActivity;
import fr.trainsapp.bas_du_corps.BasDuCorpsActivity;
import fr.trainsapp.complet.CompletActivity;
import fr.trainsapp.haut_du_corps.HautDuCorpsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Boutton vers la page Bas Du Corps
        Button button_v_bas_du_corps = (Button) findViewById(R.id.button_v_bas_du_corps);
        button_v_bas_du_corps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BasDuCorpsActivity.class);
                startActivity(intent);
            }
        });

        // Boutton vers la page Abdominaux
        Button button_v_abdominaux = (Button) findViewById(R.id.button_v_abdominaux);
        button_v_abdominaux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AbdominauxActivity.class);
                startActivity(intent);
            }
        });

        // Boutton vers la page Haut du corps
        Button button_v_haut_du_corps = (Button) findViewById(R.id.button_v_haut_du_corps);
        button_v_haut_du_corps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HautDuCorpsActivity.class);
                startActivity(intent);
            }
        });

        // Boutton vers la page Complet
        Button button_v_complet = (Button) findViewById(R.id.button_v_complet);
        button_v_complet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CompletActivity.class);
                startActivity(intent);
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