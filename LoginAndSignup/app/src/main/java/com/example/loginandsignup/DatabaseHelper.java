package com.example.loginandsignup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Currency;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String databaseName = "Singup.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table allusers(email TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists allusers");
    }
    public Boolean insertData(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", password);
        long ressult = db.insert("allusers", null, values);
        if (ressult == -1)
            return false;
        else
            return true;
    }
    public Boolean checkEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select *from allusers where email = ? ", new String[] {email});

        if (cursor.getCount() > 0) {
            return true;
        }
        else return false;
    }
    public Boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select *from allusers where email = ? and password = ?", new String[] {email, password});

        if (cursor.getCount() > 0) {
            return true;
        }
        else return false;
    }
}
