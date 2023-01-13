package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        Livraison uneLivraison = new Livraison(1, "Martin", "J'habite là");
        uneLivraison.ajouterColis(new Colis("213", 25.5f, 1));
        uneLivraison.ajouterColis(new Colis("465", 75.8f, 1));

        TextView nomTV = findViewById(R.id.nomProprio);
        TextView adresseTV = findViewById(R.id.adresseProprio);

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