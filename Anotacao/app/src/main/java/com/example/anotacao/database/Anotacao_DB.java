package com.example.anotacao.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Anotacao_DB extends SQLiteOpenHelper {

    private static final String DB_NAME = "Anotacoes_DB";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public Anotacao_DB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTable =
                "CREATE TABLE Anotacoes (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "Titulo TEXT, " +
                        "Text TEXT)";

        db.execSQL(sqlTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarObjeto(String tabela, ContentValues dados){

        db.insert(tabela, null, dados);

    }

}
