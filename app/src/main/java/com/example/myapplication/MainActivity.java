package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import android.os.Bundle;

import com.example.myapplication.BDD.ColisCRUD;
import com.example.myapplication.BDD.LivraisonCRUD;
import com.example.myapplication.Class.AdapterListe;
import com.example.myapplication.Class.Colis;
import com.example.myapplication.Class.ColisAdapter;
import com.example.myapplication.Class.Livraison;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    LivraisonCRUD livCrud;
    ColisCRUD colisCrud;
    List<Colis> lesColis;
    List<Livraison> lesLivraisons;

    public static final String CLE_INTRA = "intra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        livCrud = new LivraisonCRUD( this);
        colisCrud = new ColisCRUD(this);
    }

    public void retourback(View view) {
        Intent filter = new Intent(this, Main.class);
        startActivity(filter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        lesColis = colisCrud.get();
        lesLivraisons = livCrud.get();


        for (int l = 0; l < lesLivraisons.size(); l++){
            for (int i = 0 ; i  <  lesColis.size(); i++ ) {
                Log.i("tag", String.valueOf(lesLivraisons.get(l).getId()) +"=="+ String.valueOf(lesColis.get(i).getIdLivraison()));
                if (lesLivraisons.get(l).getId() == lesColis.get(i).getIdLivraison()){
                    lesLivraisons.get(l).ajouterColis(lesColis.get(i));
                }
            }
        }

        AdapterListe adapter = new AdapterListe(this,R.layout.liste,lesLivraisons);

        ListView liste = findViewById(R.id.maliste);
        liste.setAdapter(adapter);

    }
}