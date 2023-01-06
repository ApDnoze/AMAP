package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperer ListView

        ListView listView = findViewById(R.id.listview);

        String[] livraison = {
                "Client"
        };
    }
}