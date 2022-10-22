package com.example.thestudentandroid;

import androidx.annotation.Nullable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAlunos extends SQLiteOpenHelper {

    public static final String DBNAME = "student.db";
    public static final String TABLENAME = "students";
    public static final int VER=1;
    String query;
    public DBAlunos(@Nullable Context context) {
        super(context, DBNAME, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        query="create table "+TABLENAME+"(id integer primary key, nomeAluno text, moradaAluno text, telefoneAluno text, emailAluno text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        query="drop table if exists "+TABLENAME+"";
        db.execSQL(query);
        onCreate(db);
    }
}