package com.example.myapplication.Class;

import java.util.ArrayList;

public class Livraison {

    private int id;
    private String client;
    private String adresse;
    private ArrayList<Colis> listeColis = new ArrayList<Colis>();


    public Livraison(int id, String client, String adresse) {
        this.id = id;
        this.client = client;
        this.adresse = adresse;

    }
    public Livraison(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void ajouterColis(Colis unColis){
        this.listeColis.add(unColis);
    }

    public int nbColis(){ return this.listeColis.size(); }

    public float montantPrixLivraisonColis(){
        float montant=0.0f;
        for (Colis unColis: listeColis) {
            montant+= unColis.getMontant();
        }
        return montant;
    }

    public ArrayList<Colis> sendListeColis(){
        return this.listeColis;
    }

}
