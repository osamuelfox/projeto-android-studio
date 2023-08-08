package com.example.imc.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class IMC_BD extends SQLiteOpenHelper {

    private static final String DB_NAME = "IMC_DB";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public IMC_BD(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTable =
                "CREATE TABLE IMC (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "Peso TEXT, " +
                        "ALtura TEXT, " +
                        "Resultado TEXT)";

        db.execSQL(sqlTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarObjeto(String tabela, ContentValues dados){

        db.insert(tabela, null, dados);

    }
}
