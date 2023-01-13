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

public class Element extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);

        Log.i("test", "here1");
        Livraison uneLivraison = new Livraison(1, "Martin", "J'habite là");

        Colis unColis = new Colis("213", 25.5f, 1);
        Colis unAutreColis = new Colis("465", 75.8f, 1);
        Log.i("test", unColis.getReference());
        Log.i("test", "here2");
        uneLivraison.ajouterColis(unColis);
        uneLivraison.ajouterColis(unAutreColis);
        Log.i("test", "here3");

        TextView nomTV = findViewById(R.id.nomProprio);
        TextView adresseTV = findViewById(R.id.adresseProprio);
        Log.i("test", "here3");

        nomTV.setText(uneLivraison.getClient());
        adresseTV.setText(uneLivraison.getAdresse());


        ListView listeColisLV = findViewById(R.id.listeColis);

        ArrayList<Colis> liste = new ArrayList<Colis>();

        ArrayAdapter<Colis> arrayAdapter = new ArrayAdapter<Colis>(
                this,android.R.layout.simple_list_item_1 , uneLivraison.sendListeColis()
        );

        listeColisLV.setAdapter(arrayAdapter);


    }
}