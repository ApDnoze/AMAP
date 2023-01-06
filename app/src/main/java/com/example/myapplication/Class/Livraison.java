package com.example.myapplication.Class;

public class Livraison {

    private int id;
    private String client;
    private String adresse;


    public Livraison(int id, String client, String adresse) {
        this.id = id;
        this.client = client;
        this.adresse = adresse;
    }
    private Livraison(){

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




}
