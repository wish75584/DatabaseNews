package com.bytessystem.databasenews;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "post.db";

    private static final String SQL_CREATE_POST =
            " CREATE TABLE POST (pid INTEGER PRIMARY KEY AUTOINCREMENT,psub TEXT,pdesc TEXT,pdate INTEGER,pcounter INTEGER DEFAULT '0')";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_POST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}


