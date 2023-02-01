package com.example.myapplication.BDD;

public class LivraisonTable {
    public static final String TABLE_NAME = "livraison";

    public static final String COL_ID = "id";
    public static final String COL_CLIENT = "client";
    public static final String COL_RUE = "rue";
    public static final String COL_POSITION = "position";


    public static final String CREATE_TABLE = "CREATE TABLE " +
            TABLE_NAME +
            " (" +
            COL_ID +
            " INTEGER PRIMARY KEY ," +
            COL_CLIENT +
            " TEXT," +
            COL_RUE +
            " TEXT);"+
            COL_POSITION +
            " INTEGER);";;

    public static final String DROP_TABLE = "DROP TABLE "+ TABLE_NAME;
}
