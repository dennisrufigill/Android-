package com.example.newtasksharedprefs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDatabase.db";
    public static final String TABLE_NAME = "Mytable";

    public static final String COL1 = "ID";
    public static final String COL2 = "EMAIL";
    public static final String COL3 = "NAME";
    public static final String COL4 = "FATHERNAME";
    public static final String COL5 = "PHONE";
    public static final String COL6 = "PASSWORD";
    public static final String COL7 = "CONFIRMPASSWORD";
    public static final String COL8 = "GENDER";
    public static final String COL9 = "COUNTRY";
    public static final String COL10 = "CITY";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //  sqLiteDatabase.execSQL();
        //sqLiteDatabase.execSQL("create table " + TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, PHONE TEXT)");
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, NAME TEXT,FATHERNAME TEXT, PHONE NUMBER, PASSWORD PASSWORD, CONFIRMPASSWORD PASSWORD, GENDER TEXT, COUNTRY TEXT, CITY TEXT ) ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public boolean addUser(String email, String name, String fathername, Integer phone, String password, String confirmpassword,
                           String gender, String country, String city) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, email);
        contentValues.put(COL3, name);
        contentValues.put(COL4, fathername);
        contentValues.put(COL5, phone);
        contentValues.put(COL6, password);
        contentValues.put(COL7, confirmpassword);
        contentValues.put(COL8, gender);
        contentValues.put(COL9, country);
        contentValues.put(COL10, city);

        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }




    public Cursor getData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("Select * from " + TABLE_NAME, null);
        return res;
    }



    public boolean login(String email, String password){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(" select * from " + TABLE_NAME  + " where EMAIL = ?  AND PASSWORD = ?", new String[]{email,password});

        if(cursor !=null){
             if(cursor.getCount() >0){
                 return  true;
             }
        }
        return false;
    }

}
