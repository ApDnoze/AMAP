package com.example.myapplication.BDD;

public class ColisTable {
    public static final String TABLE_NAME = "colis";

    public static final String COL_REF = "ref";
    public static final String COL_MONTANT = "montant";
    public static final String COL_LIVRAISON = "id";

    public static final String CREATE_TABLE = "CREATE TABLE " +
            TABLE_NAME +
            " (" +
            COL_REF +
            " TEXT PRIMARY KEY," +
            COL_MONTANT +
            " FLOAT," +
            COL_LIVRAISON +
            " INTEGER);";

    public static final String DROP_TABLE = "DROP TABLE "+ TABLE_NAME;
}
