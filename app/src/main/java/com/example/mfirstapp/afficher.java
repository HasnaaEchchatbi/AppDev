package com.example.mfirstapp;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class afficher extends AppCompatActivity {
    DBconnexion db ;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last);
        Intent intent = getIntent();
        String ville = intent.getStringExtra("ville");
        int nbAnnonces = db.countJobsByCity(ville);


        TextView textViewNbAnnonces = findViewById(R.id.textViewNbAnnonces);
        textViewNbAnnonces.setText("Nombre d'annonces dans " + ville + " : " + nbAnnonces);

    }








    }  /*TextView textViewNombreAnnonces = findViewById(R.id.textViewNbAnnonces);
        Bundle b=getIntent().getExtras();
        String user=b.getString("ville");

            int nombreAnnonces = getIntent().getIntExtra("nombreAnnonces", 0);
            String ville = getIntent().getStringExtra("ville");

            textViewNombreAnnonces.setText("il y'a acctuellment " + nombreAnnonces+"annonce(s) sur "+user);
        }*/




