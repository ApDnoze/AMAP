package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.BDD.ColisCRUD;
import com.example.myapplication.BDD.LivraisonCRUD;
import com.example.myapplication.Class.Colis;
import com.example.myapplication.Class.ColisAdapter;
import com.example.myapplication.Class.Livraison;

import java.util.ArrayList;
import java.util.List;

public class Element extends AppCompatActivity {

    LivraisonCRUD livCrud;
    ColisCRUD colisCrud;
    List<Colis> lesColis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);

        livCrud = new LivraisonCRUD( this);
        colisCrud = new ColisCRUD(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        int idElement = (int) getIntent().getSerializableExtra("element");

        Livraison livraison = livCrud.getFromId(idElement);
        lesColis = colisCrud.getId(livraison.getId());

        livraison.setListColis(lesColis);



        TextView nomTV = findViewById(R.id.nomProprio);
        TextView adresseTV = findViewById(R.id.adresseProprio);
        nomTV.setText(livraison.getClient());
        adresseTV.setText(livraison.getAdresse());


        ColisAdapter adapter = new ColisAdapter(this, R.layout.presentation_colis, (ArrayList<Colis>) livraison.sendListeColis());

        ListView listeColisLV = findViewById(R.id.listeColis);
        listeColisLV.setAdapter(adapter);
    }

    public void retourListeElemment(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}