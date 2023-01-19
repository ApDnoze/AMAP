package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.Class.Colis;
import com.example.myapplication.Class.Livraison;

import java.util.ArrayList;
import java.util.List;

public class Element extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);

        Livraison uneLivraison = new Livraison(1, "Martin", "J'habite là");

        Colis unColis = new Colis("213", 25.5f, 1);
        Colis unAutreColis = new Colis("465", 75.8f, 1);
        uneLivraison.ajouterColis(unColis);
        uneLivraison.ajouterColis(unAutreColis);

        TextView nomTV = findViewById(R.id.nomProprio);
        TextView adresseTV = findViewById(R.id.adresseProprio);

        nomTV.setText(uneLivraison.getClient());
        adresseTV.setText(uneLivraison.getAdresse());


        ArrayList<Colis> liste = new ArrayList<Colis>();

        ArrayAdapter<Colis> arrayAdapter = new ArrayAdapter<>(this, R.layout.presentation_colis, R.id.reference, uneLivraison.sendListeColis());
        /*
        ArrayAdapter<Colis> arrayAdapter = new ArrayAdapter<Colis>(
                this,R.layout.presentation_colis , uneLivraison.sendListeColis());


         */
        ListView listeColisLV = findViewById(R.id.listeColis);
        listeColisLV.setAdapter(arrayAdapter);


    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}