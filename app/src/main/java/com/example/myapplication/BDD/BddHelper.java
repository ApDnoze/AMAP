package com.example.myapplication.BDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BddHelper extends SQLiteOpenHelper {
    public BddHelper(@Nullable Context context) { super(context, "fichier.db", null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LivraisonTable.CREATE_TABLE);
        db.execSQL(ColisTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(LivraisonTable.DROP_TABLE);
        db.execSQL(ColisTable.DROP_TABLE);
        onCreate(db);
    }
}
