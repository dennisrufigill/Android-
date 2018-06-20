package dennis.example.com.iufest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dennis on 12/17/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static  final String DATABASE_NAME = "Faculty.db";
    public static  final String TABLE_NAME = "facultytable";
    public static  final String COL1= "ID";
    public static  final String COL2 = "NAME";
    public static  final String COL3 = "SURNAME";
    public static  final String COL4 = "DESIGNATION";






    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
      //  SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT,DESIGNATION TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);

    }


    public boolean insertData(String name, String surname, String designation)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,surname);
        contentValues.put(COL4,designation);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return  false;
        else
            return true;


    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + TABLE_NAME,null);
        return res;
    }


    public boolean updateData(String id,String name, String surname, String designation)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,id);
        contentValues.put(COL2,name);
        contentValues.put(COL3,surname);
        contentValues.put(COL4,designation);

        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;

    }

    public Integer deleteData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        return  db.delete(TABLE_NAME, "ID = ?" ,new String[]{id});
    }




}
