package com.example.myapplication.BDD;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.Class.Livraison;

import java.util.ArrayList;
import java.util.List;

public class LivraisonCRUD {
    private SQLiteDatabase db;
    private BddHelper helper;

    public LivraisonCRUD (Context ctx){
        helper = new BddHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public long insert(Livraison Livraison){
        ContentValues cv = new ContentValues();
        cv.put(LivraisonTable.COL_ID, Livraison.getId());
        cv.put(LivraisonTable.COL_CLIENT, Livraison.getClient());
        cv.put(LivraisonTable.COL_RUE, Livraison.getAdresse());

        return db.insert(LivraisonTable.TABLE_NAME, null, cv);
    }

    @SuppressLint("Range")
    public List<Livraison> get(){
        List<Livraison> resultat = new ArrayList<>();

        Cursor cursor = db.query(
                LivraisonTable.TABLE_NAME,
                new String[]{LivraisonTable.COL_CLIENT, LivraisonTable.COL_RUE, LivraisonTable.COL_ID},
                null,
                null,
                null,
                null,
                null,
                null
        );

        while(cursor.moveToNext()){
            Livraison livraison = new Livraison();
            livraison.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(LivraisonTable.COL_ID))));
            livraison.setClient(cursor.getString(cursor.getColumnIndex(LivraisonTable.COL_CLIENT)));
            livraison.setAdresse(cursor.getString(cursor.getColumnIndex(LivraisonTable.COL_RUE)));
            resultat.add(livraison);
        }
        return resultat;
    }

    public long delete (){
        return db.delete(LivraisonTable.TABLE_NAME, null, null);
    }
}
