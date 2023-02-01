package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.Class.Livraison;
import com.example.myapplication.BDD.LivraisonCRUD;
import com.example.myapplication.BDD.ColisCRUD;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main extends AppCompatActivity {
    LitFichier fichierlu = new LitFichier();
    LivraisonCRUD livCrud;
    ColisCRUD colisCrud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        livCrud = new LivraisonCRUD( this);
        colisCrud = new ColisCRUD(this);
        fichierlu.execute("https://stpolsisl.fr/livraisons.xml");
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

            Log.i("tag", "début");

            try{
                if (fichierlu.get()){
                    Log.i("tag", fichierlu.donneNoms());

                    List<Livraison> lesLivraison = fichierlu.geLivraison();
                    for (int i = 0 ; i  >  lesLivraison.size(); i++ ) {
                        livCrud.insert(lesLivraison.get(i));
                        for (int l = 0 ; l  >  lesLivraison.get(i).sendListeColis().size(); l++ ) {
                            colisCrud.insert(lesLivraison.get(i).sendListeColis().get(l));
                        }
                    }
                    //Log.i("tag", lesLivraison.get());

                    Thread.sleep(3000);

                    publishProgress(100);
                }
                else {
                    Log.i("tag","pb de lecture sur le fichier");
                }
            }
            catch (InterruptedException e){
                Log.i("tag", "interruption lecture de fichiers");
            }
            catch (ExecutionException e){
                Log.i("tag", "problème execution ");
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