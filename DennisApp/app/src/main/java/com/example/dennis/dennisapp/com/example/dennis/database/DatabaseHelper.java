package com.example.dennis.dennisapp.com.example.dennis.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dennis on 10/11/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(Driver.TABLE_DRIVER_CREATE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL(Driver.TABLE_DRIVER_DROP);
        onCreate(db);

    }
}
