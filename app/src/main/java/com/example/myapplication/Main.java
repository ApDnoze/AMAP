package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void loadBdd(View view) {
        Intent filter = new Intent(this, MainActivity.class);
        startActivity(filter);
    }

    public void goFilter(View view) {
        Intent filter = new Intent(this, MainActivity.class);
        startActivity(filter);
    }

    public void showLivraison(View view) {
        Intent filter = new Intent(this, MainActivity.class);
        startActivity(filter);
    }
}