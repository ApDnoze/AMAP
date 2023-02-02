package com.example.myapplication;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.myapplication.Class.Livraison;
import com.example.myapplication.BDD.LivraisonCRUD;
import com.example.myapplication.BDD.ColisCRUD;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main extends AppCompatActivity {
    LitFichier fichierlu;
    LivraisonCRUD livCrud;
    ColisCRUD colisCrud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getSupportActionBar().hide();

        fichierlu = new LitFichier();
        livCrud = new LivraisonCRUD( this);
        colisCrud = new ColisCRUD(this);
        fichierlu.execute("https://stpolsisl.fr/livraisons.xml");
    }

    public void loadBdd(View view) throws InterruptedException {
        colisCrud.delete();
        livCrud.delete();
        Loader progress = new Loader();
        progress.execute();
    }

    public void goFilter(View view) {
        Intent filter = new Intent(this, Trier.class);
        //startActivity(filter);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            startActivity(filter,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        }
    }

    public void showLivraison(View view) {
        Intent filter = new Intent(this, MainActivity.class);
        //startActivity(filter);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(new Explode());
            startActivity(filter,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        }
    }

    private class Loader extends AsyncTask<Void, Integer, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(Void... voids) {

            //Ce qu'il faut faire pour récupérer les données XML en BackGround


            try{
                if (fichierlu.get()){

                    List<Livraison> lesLivraison = fichierlu.geLivraison();
                    for (int i = 0 ; i  <  lesLivraison.size(); i++ ) {
                        livCrud.insert(lesLivraison.get(i));
                        for (int l = 0 ; l  <  lesLivraison.get(i).sendListeColis().size(); l++ ) {
                            colisCrud.insert(lesLivraison.get(i).sendListeColis().get(l));
                        }
                    }

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