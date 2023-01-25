package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import android.os.Bundle;

import com.example.myapplication.Class.AdapterListe;
import com.example.myapplication.Class.Colis;
import com.example.myapplication.Class.ColisAdapter;
import com.example.myapplication.Class.Livraison;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String CLE_INTRA = "intra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Livraison> listeLivraison = new ArrayList<Livraison>();
        Livraison l1 = new Livraison(1,"Vincent","Orleans");
        Colis c1 = new Colis("1234",195,1);
        Colis c2 = new Colis("12345",5,1);
        l1.ajouterColis(c1);
        l1.ajouterColis(c2);
        listeLivraison.add(l1);



        Livraison l2 = new Livraison(2,"Beytullah","Mer");
        Colis c3 = new Colis("1234567",250,2);
        Colis c4 = new Colis("1234568",250,2);
        Colis c5 = new Colis("1234569",250,2);
        l2.ajouterColis(c3);
        l2.ajouterColis(c4);
        l2.ajouterColis(c5);
        listeLivraison.add(l2);



        Livraison l3 = new Livraison(3,"Elijah","Vitry");
        Colis c6 = new Colis("12345686",90,3);
        l3.ajouterColis(c6);
        listeLivraison.add(l3);

        AdapterListe adapter = new AdapterListe(this,R.layout.liste,listeLivraison);

        ListView liste = findViewById(R.id.maliste);
        Log.i("TAG", String.valueOf(adapter));
        liste.setAdapter(adapter);





    }
}