//package com.example.testsqlite;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class PeopleDataSource {
//    // khai báo các trường database
//    private SQLiteDatabase database;
//    private String allColoumns[] = {SQLiteHelper.COLUMN_ID, SQLiteHelper.COLUMN_PERSON};
//
//    public PeopleDataSource(Context context) {
//        dbHelper = new SQLiteHelper(context);
//    }
//    public void open() throws SQLException{
//        database = dbHelper.getWritableDatabase();
//    }
//    public void close() {
//        dbHelper.close();
//    }
//    public Person createPerson(String name) {
////        class contentvalue dùng để thêm mới một hàng vào bảng và ánh xạ giá trị sang các cột tương ứng
//        ContentValues values = new ContentValues();
//        values.put(SQLiteHelper.COLUMN_PERSON, name);
//        long insertID = database.insert(SQLiteHelper.TABLE_PEOPLE, null, values);
//        Cursor cursor = database.query(SQLiteHelper.TABLE_PEOPLE, allColoumns,
//                SQLiteHelper.COLUMN_ID + "="+insertID,
//                null, null, null, null);
//        cursor.moveToFirst();
//        Person newperson = cursorToPerson(cursor);
//        cursor.close();
//        return newperson;
//    }
//    public List<Person> getAllPeople() {
//        List<Person> people = new ArrayList<Person>();
//        Cursor cursor = database.query(SQLiteHelper.TABLE_PEOPLE, allColoumns,
//                null, null, null, null, null);
//        // bắt đầu từ Table
//        cursor.moveToFirst();
//        // cursor đã isAfterLast ở cuối bảng
//        while (!cursor.isAfterLast()) {
//            Person person = cursorToPerson(cursor);
//            people.add(person);
//            cursor.moveToNext();
//        }
//        cursor.close();
//        return people;
//    }
//    private Person cursorToPerson(Cursor cursor) {
//        Person person = new Person();
//        person.setId(cursor.getLong(0));
//        person.setName(cursor.getString(1));
//        return person;
//    }
//
//}
