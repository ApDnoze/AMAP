package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String CLE_INTRA = "intra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperer ListView



        String[] livraison = {
                "Client"
        };
    }

    public void rejoindreElement(View view) {
        Intent intent = new Intent(this, Element.class);
        startActivity(intent);

    }
}