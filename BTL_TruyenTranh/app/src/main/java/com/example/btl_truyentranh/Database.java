package com.example.btl_truyentranh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import androidx.annotation.Nullable;

import Cothebanthich_Adapter.Book;
import Gridview_TruyenHot.HotAdapter_Helper;

public class Database extends SQLiteOpenHelper {
    private static final String databaseName = "LibraryManagement";
    private static String DB_path= "/data/data/com.example.btl_truyentranh2/databases/LibraryManagement/";
    public static final String tableName = "Book1";
    public static final String createBookTable = "CREATE TABLE IF NOT EXISTS " + tableName+
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Image blob, Title NVARCHAR(50), Author NVARCHAR(30), " +
            "Description NVARCHAR(100)," +
            "Subj NVARCHAR(30), Pdf char(20));";

    public static final String insertData = "insert into "+
            tableName+ "(Image, Title, Author, Description, Subj, Pdf) values"+
            "('slider1', 'Giết con chim nhại', 'Harper Lee', 'Mô tả này dành cho truyện của Harper Lee', 'Kinh dị', 'tailieu.pdf'),"+
            "('slider2', 'Vụ án', 'Franz Kafka', 'Mô tả này dành cho truyện của Franz Kafka', 'Trinh thám', 'truyen2.pdf')," +
            "('img_2', 'Bắt trẻ đồng xanh', 'J.D. Salinger', 'Mô tả này dành cho truyện của J.D. Salinger', 'Ngôn tình', 'tailieu.pdf')," +
            "('slider4', 'Anh em nhà Karamazov', 'Fyodor Dostoevsky', 'Mô tả này dành cho truyện của Fyodor Dostoevsky', 'Tiểu thuyết', 'truyen2.pdf')," +
            "('slider5', 'Anna Karenina', 'Leo Tolstoy', 'Mô tả này dành cho truyện của Leo Tolstoy', 'Anime', 'tailieu.pdf')," +
            "('slider5', 'Hồn ma đêm Giáng sinh', 'Charles Dickens', 'Mô tả này dành cho truyện của Charles Dickens', 'Khoa học', 'truyen2.pdf')," +
            "('img_3', 'Hoàng tử bé', 'Antoine de Saint-Exupéry', 'Mô tả này dành cho truyện của Antoine de Saint-Exupéry ', 'Kinh dị', 'tailieu.pdf')," +
            "('img_3', 'Trăm năm cô đơn', 'Gabriel Garcia Marquez', 'Mô tả này dành cho truyện của Gabriel Garcia Marquez', 'Trinh thám', 'truyen2.pdf' )," +
            "('img_3', 'Nhất định phải nói yêu anh', 'Xuân Diệu', 'Mô tả này dành cho truyện của Xuân Diệu', 'Ngôn tình', 'tailieu.pdf')," +
            "('slider4', 'Mật mã Da Vinci', 'Dan Brown', 'Mô tả này dành cho truyện của Dan Brown', 'Kinh dị', 'tailieu.pdf')," +
            "('slider4', 'Sherlock Holmes', 'Arthur Conan Doyle', 'Mô tả này dành cho truyện của Arthur Conan Doyle', 'Trinh thám', 'truyen2.pdf')," +
            "('slider4', 'Sự im lặng của bầy cừu', 'Thomas Harris', 'Mô tả này dành cho truyện của Thomas Harris', 'Ngôn tình', 'tailieu.pdf')," +
            "('slider4', 'Án mạng trên sông Nile', 'Agatha Christie', 'Mô tả này dành cho truyện của Agatha Christie', 'Ngôn tình', 'truyen2.pdf')" +
            ";";
    public Database( Context context
            , @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    // câu lệnh không trả về kết quả
    public void Query(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    // câu lệnh co trả về kết quả
    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    public void addBook(byte[] img, String name_book, String author,  String desc, String subject) {
        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("Title", name_book);
//        values.put("Author", author);
//        values.put("Image", img);
//        values.put("Desc", desc);
//        values.put("Subj", subject);
//        db.insert("Book", null, values);
        String sql = "insert into Book values (null, ?, ?, ?, ?, ?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.bindBlob(1, img);
        statement.bindString(2, name_book);
        statement.bindString(3, author);
        statement.bindString(4, desc);
        statement.bindString(5, subject);
        statement.executeInsert();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
