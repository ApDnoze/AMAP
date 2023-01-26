package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageView mImageView = findViewById(R.id.image_view_1);
        mImageView.animate().rotation(360f).setDuration(4000).start();
        try {
            Log.i("tag","Test");
            Thread.sleep(mImageView.animate().getDuration());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loadBdd(View view) {


        Loader progress = new Loader();
        progress.execute();

    }

    public void goFilter(View view) {
        Intent filter = new Intent(this, Trier.class);
        startActivity(filter);
    }

    public void showLivraison(View view) {
        Intent filter = new Intent(this, MainActivity.class);
        startActivity(filter);
    }

    private class Loader extends AsyncTask<Void, Integer, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(Void... voids) {

            //Ce qu'il faut faire pour récupérer les données XML en BackGround

            for(int i = 0; i<=10; i++)
            {
                publishProgress(i);
                try
                {
                    Thread.sleep(500);

                    Log.i("Dieu", String.valueOf(i));
                } catch (InterruptedException e)
                {
                    Log.i("Dieu", e.getMessage());
                }
            }

            return "C'est terminé";
        }

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(
                    Main.this,
                    "Veuillez patienter",
                    "Chargement des livraisons...");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {


        }

        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            progressDialog.dismiss();
        }



    }
}