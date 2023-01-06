package com.example.myapplication.Class;

public class Colis {

    private String reference;
    private float montant;
    private int idLivraison;

    public Colis(String reference, float montant, int idLivraison) {
        this.reference = reference;
        this.montant = montant;
        this.idLivraison = idLivraison;
    }

    public Colis(){

    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public int getIdLivraison() {
        return idLivraison;
    }

    public void setIdLivraison(int idLivraison) {
        this.idLivraison = idLivraison;
    }
}
