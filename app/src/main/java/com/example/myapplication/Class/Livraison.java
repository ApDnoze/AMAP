package com.example.myapplication.Class;

import java.util.ArrayList;

public class Livraison {

    private int id;
    private String client;
    private String adresse;
    private int position;
    private ArrayList<Colis> listeColis = new ArrayList<Colis>();


    public Livraison(int id, String client,String adresse, int position) {
        this.id = id;
        this.client = client;
        this.adresse = adresse;
        this.position = position;

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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void ajouterColis(Colis unColis){
        this.listeColis.add(unColis);
    }

    public int nbColis(){ return this.listeColis.size(); }

    public float montantPrixLivraisonColis(){
        float montant=0.0f;
        for (Colis unColis: listeColis) {
            montant += unColis.getMontant();
        }
        return montant;
    }

    public ArrayList<Colis> sendListeColis(){
        return this.listeColis;
    }

}
