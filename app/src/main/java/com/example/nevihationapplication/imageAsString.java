package com.example.nevihationapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class imageAsString extends SQLiteOpenHelper {
    public static final String databaseNameS="imageS";
    public static final String tableNameS="imageString";
    public static final String cs1="ID";
    public static final String cs2="IMAGE";
    public imageAsString( Context context) {
        super(context, databaseNameS, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tableNameS+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,IMAGE TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableNameS);
        onCreate(db);

    }
    public boolean addImage(String simg)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(cs2,simg);
        long result=db.insert(tableNameS,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }
    public Cursor viewImageS()
    {
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery("Select * from "+tableNameS,null);

        return cursor;

    }
    public void deleteData()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Delete  from "+tableNameS,null);
    }
}
