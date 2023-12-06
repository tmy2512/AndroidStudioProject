package com.example.btl_truyentranh2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.ContentHandler;

import javax.xml.validation.Validator;

public class FavDB extends SQLiteOpenHelper {
    private static int DB_version = 1;
    private static String DATABASE_NAME = "BookDB";
    private static String TABLE_NAME = "favoriteBook";
    public static String ID ="id";
    public static String IMAGE ="image";
    public static String TITLE ="title";
    public static String AUTHOR ="author";
    public static String SUBJECT ="subject";
    public static String DESCRIPTION ="description";
    public static String PDF_NAME ="pdfName";
    public static String FAVORITE_STATUS ="fStatus";
    private static String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "(" +
            ID+ " TEXT, "+ IMAGE+ " TEXT, "+ TITLE+" TEXT, "+AUTHOR+" TEXT, "+ SUBJECT+" TEXT, "+ DESCRIPTION+" TEXT, "+");";
    public FavDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // create empty table
    public void insertEmpty() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (int i = 1; i < 11; i++) {
            values.put(ID, i);
            values.put(FAVORITE_STATUS, 0);
            db.insert(TABLE_NAME, null, values);
        }
    }

    // insert data into DB
    public void insertIntoDatabase(String title, String author, String subject, String description, String id, String image, String fav_status) {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TITLE, title);
        cv.put(IMAGE, image);
        cv.put(AUTHOR, author);
        cv.put(SUBJECT, subject);
        cv.put(DESCRIPTION, description);
        cv.put(ID, id);
        cv.put(FAVORITE_STATUS, fav_status);
        db.insert(TABLE_NAME, null, cv);
    }
    // read data
    public Cursor readAllData(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from "+TABLE_NAME+" WHERE "+ ID +"= "+ id+"";
        return db.rawQuery(sql, null, null);
    }
    // remove line from db
    public void remove_fav(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "update "+TABLE_NAME+ " set "+ FAVORITE_STATUS+ "= '0' WHERE "+ ID +"= "+ id+"";
        db.execSQL(sql);

    }
    //select all favorite
    public Cursor getFavoriteList() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from "+TABLE_NAME +" WHERE "+FAVORITE_STATUS +"='1'";
        return db.rawQuery(sql, null, null);
    }
}
