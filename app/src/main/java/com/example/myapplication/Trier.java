package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.BDD.ColisCRUD;
import com.example.myapplication.BDD.LivraisonCRUD;
import com.example.myapplication.Class.AdapterListe;
import com.example.myapplication.Class.AdapterListeTrier;
import com.example.myapplication.Class.Colis;
import com.example.myapplication.Class.Livraison;

import java.util.ArrayList;
import java.util.List;

public class Trier extends AppCompatActivity {

    LivraisonCRUD livCrud;
    ColisCRUD colisCrud;
    List<Colis> lesColis;
    List<Livraison> lesLivraisons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        livCrud = new LivraisonCRUD( this);
        colisCrud = new ColisCRUD(this);

        setContentView(R.layout.activity_trier);
    }

    protected void onResume() {
        super.onResume();

        lesColis = colisCrud.get();
        lesLivraisons = livCrud.get();

        for (int i = 0 ; i  <  lesColis.size(); i++ ) {
            lesLivraisons.get(lesColis.get(i).getIdLivraison()).ajouterColis(lesColis.get(i));
        }

        AdapterListeTrier adapter = new AdapterListeTrier(this,R.layout.liste,lesLivraisons);

        ListView liste = findViewById(R.id.maliste);
        liste.setAdapter(adapter);


        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Livraison laview = adapter.getItem(i);
                adapter.remove(adapter.getItem(i));

                adapter.insert(laview, 0);

                for (int j = 0; j < lesLivraisons.size(); j++){
                    adapter.getItem(j).setPosition(j);
                    Log.i("TAG", String.valueOf(adapter.getItem(j).getPosition()));
                }


            }
        });


    }


    public void retourMenu(View view) {

        colisCrud.delete();
        livCrud.delete();

        List<Livraison> lesLivraison = lesLivraisons;
        for (int i = 0 ; i  <  lesLivraison.size(); i++ ) {
            livCrud.insert(lesLivraison.get(i));
            for (int l = 0; l < lesLivraison.get(i).sendListeColis().size(); l++) {
                colisCrud.insert(lesLivraison.get(i).sendListeColis().get(l));
            }
        }


        onBackPressed();
    }
}