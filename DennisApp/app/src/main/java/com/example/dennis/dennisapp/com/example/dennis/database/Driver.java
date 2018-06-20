package com.example.dennis.dennisapp.com.example.dennis.database;

/**
 * Created by Dennis on 10/11/2016.
 */
public class Driver {


    public static String TABLE_DRIVER = "Driver";

    public static String DRIVER_ID = "DriverID";
    public static String DRIVER_NAME = "DriverName";

    public static String TABLE_DRIVER_CREATE = "CREATE TABLE " + TABLE_DRIVER
            + "(" + DRIVER_ID + " INTEGER PRIMARY KEY, " + DRIVER_NAME
            + " Text" + ");";

    public static String TABLE_DRIVER_DROP = "DROP TABLE IF EXIST " + TABLE_DRIVER;



}
