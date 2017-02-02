package com.dev.joliveira.agendahair.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ADM on 31/01/2017.
 */

public class DataBase extends SQLiteOpenHelper {

    //criador do banco de dados
    public DataBase(Context context)
    {
        super(context, "AGENDA_HAIR", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ScriptSql.getCreateDadosComercio());//criando tabela
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
