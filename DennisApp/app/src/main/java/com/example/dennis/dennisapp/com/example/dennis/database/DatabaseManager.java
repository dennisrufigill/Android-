package com.example.dennis.dennisapp.com.example.dennis.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Dennis on 10/11/2016.
 */
public class DatabaseManager {

    DatabaseHelper dbh;
    SQLiteDatabase connection;
    static DatabaseManager dbm = null;

    private DatabaseManager(Context context)
    {
        dbh = new DatabaseHelper(context,"MyDb.db",null,1);
        connection =dbh.getWritableDatabase();

    }
public static DatabaseManager getInstance(Context context)
{
    if(dbm == null){
        dbm = new DatabaseManager(context);
    }

    return dbm;
}
    public void AddDriver(DriverBean dri){

        connection = dbh.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Driver.DRIVER_NAME, dri.getName());

        connection.insert(Driver.TABLE_DRIVER, null, cv);
        connection.close();

    }
}
