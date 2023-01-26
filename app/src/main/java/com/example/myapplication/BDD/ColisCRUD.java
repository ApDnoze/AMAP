package com.example.myapplication.BDD;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.Class.Colis;
import com.example.myapplication.BDD.ColisTable;

import java.util.ArrayList;
import java.util.List;

public class ColisCRUD {

    private SQLiteDatabase db;
    private BddHelper helper;

    public ColisCRUD (Context ctx){
        helper = new BddHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public long insert(Colis colis){
        ContentValues cv = new ContentValues();
        cv.put(ColisTable.COL_REF, colis.getReference());
        cv.put(ColisTable.COL_MONTANT, colis.getMontant());
        cv.put(ColisTable.COL_LIVRAISON, colis.getIdLivraison());
        return db.insert(ColisTable.TABLE_NAME, null, cv);
    }

    @SuppressLint("Range")
    public List<Colis> get(){
        List<Colis> resultat = new ArrayList<>();

        Cursor cursor = db.query(
                ColisTable.TABLE_NAME,
                new String[]{ColisTable.COL_REF, ColisTable.COL_MONTANT, ColisTable.COL_LIVRAISON},
                null,
                null,
                null,
                null,
                null,
                null
        );

        while(cursor.moveToNext()){
            Colis colis = new Colis();
            colis.setReference(cursor.getString(cursor.getColumnIndex(ColisTable.COL_REF)));
            colis.setMontant(Float.parseFloat(cursor.getString(cursor.getColumnIndex(ColisTable.COL_MONTANT))));
            colis.setIdLivraison(cursor.getInt(cursor.getColumnIndex(ColisTable.COL_LIVRAISON)));
            resultat.add(colis);
        }
        return resultat;
    }

    @SuppressLint("Range")
    public List<Colis> getId(int id){
        List<Colis> resultat = new ArrayList<>();

        Cursor cursor = db.query(
                ColisTable.TABLE_NAME,
                new String[]{ColisTable.COL_REF, ColisTable.COL_MONTANT, ColisTable.COL_LIVRAISON},
                ColisTable.COL_LIVRAISON+"="+id,
                null,
                null,
                null,
                null,
                null
        );

        while(cursor.moveToNext()){
            Colis colis = new Colis();
            colis.setReference(cursor.getString(cursor.getColumnIndex(ColisTable.COL_REF)));
            colis.setMontant(Float.parseFloat(cursor.getString(cursor.getColumnIndex(ColisTable.COL_MONTANT))));
            colis.setIdLivraison(cursor.getInt(cursor.getColumnIndex(ColisTable.COL_LIVRAISON)));
            resultat.add(colis);
        }
        return resultat;
    }

    public long delete (){
        return db.delete(ColisTable.TABLE_NAME, null, null);
    }

}
