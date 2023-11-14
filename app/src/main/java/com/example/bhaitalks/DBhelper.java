package com.example.bhaitalks;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {

    public DBhelper(@Nullable Context context ) {
        super(context, "bhaitalks.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table users(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT,PHONE INTEGER,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE if EXISTS users");
        onCreate(DB);
    }

    public boolean insertData(String name,String email,String phone,String password)
    {
        SQLiteDatabase DB=this.getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(name, name);
        contentValues.put(email, email);
        contentValues.put(phone, phone);
        contentValues.put(password, password);
        long result=DB.insert("users",null ,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
}
