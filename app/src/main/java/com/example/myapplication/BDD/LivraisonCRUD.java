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

    public long insert(Livraison livraison){
        ContentValues cv = new ContentValues();
        cv.put(LivraisonTable.COL_ID, livraison.getId());
        cv.put(LivraisonTable.COL_CLIENT, livraison.getClient());
        cv.put(LivraisonTable.COL_RUE, livraison.getAdresse());
        cv.put(LivraisonTable.COL_POSITION, livraison.getPosition());

        //Log.i("TAG", livraison.getClient());
        return db.insert(LivraisonTable.TABLE_NAME, null, cv);
    }

    @SuppressLint("Range")
    public List<Livraison> get(){
        List<Livraison> resultat = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM livraison ORDER BY position", null);

        while(cursor.moveToNext()){
            Livraison livraison = new Livraison();
            livraison.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(LivraisonTable.COL_ID))));
            livraison.setClient(cursor.getString(cursor.getColumnIndex(LivraisonTable.COL_CLIENT)));
            livraison.setAdresse(cursor.getString(cursor.getColumnIndex(LivraisonTable.COL_RUE)));
            //Log.i("TAG", livraison.getClient());
            resultat.add(livraison);
        }
        return resultat;
    }

    @SuppressLint("Range")
    public Livraison getFromId(int idLivraison){
        Livraison livraison = new Livraison();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM livraison WHERE id="+idLivraison+";",
                null);

        while(cursor.moveToNext()){

            livraison.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(LivraisonTable.COL_ID))));
            livraison.setClient(cursor.getString(cursor.getColumnIndex(LivraisonTable.COL_CLIENT)));
            livraison.setAdresse(cursor.getString(cursor.getColumnIndex(LivraisonTable.COL_RUE)));
            //Log.i("TAG", livraison.getClient());
        }
        return livraison;
    }

    public long delete (){
        return db.delete(LivraisonTable.TABLE_NAME, null, null);
    }

}
