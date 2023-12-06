package com.example.btl_truyentranh2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import java.io.File;

import Gridview_TruyenHot.HotAdapter_Helper;

public class Database extends SQLiteOpenHelper {
    private static final String databaseName = "LibraryManagement";
    private static String DB_path= "/data/data/com.example.btl_truyentranh2/databases/LibraryManagement/";
    public static final String tableName = "Book1";
    public static final String createBookTable = "CREATE TABLE IF NOT EXISTS " + tableName+
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Image CHAR(10), Title NVARCHAR(50), Author NVARCHAR(30), " +
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
    public Database(@Nullable Context context) {
        super(context, databaseName, null, 1);

    }

    private boolean checkDatabase() {
        File dbFile = new File(DB_path + databaseName);
        if (dbFile.exists()) {
            return true;
        }
        else {
            dbFile.getParentFile().mkdir();
            return false;
        }
    }
    // câu lệnh không trả về
    public void Query(String sql) {
        SQLiteDatabase data = getWritableDatabase();
        data.execSQL(sql);
    }
    // câu ệnh có trả về kết quả
    public Cursor cursor(String sql) {
        SQLiteDatabase data = getReadableDatabase();
        return data.rawQuery(sql, null);
    }
//    public void addBook(byte[] img, String name_book, String author,  String desc, String subject) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        String sql = "insert into Book values (null, ?, ?, ?, ?, ?)";
//        SQLiteStatement statement = db.compileStatement(sql);
//        statement.clearBindings();
//        statement.bindBlob(1, img);
//        statement.bindString(2, name_book);
//        statement.bindString(3, author);
//        statement.bindString(4, desc);
//        statement.bindString(5, subject);
//        statement.executeInsert();
//
//    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(createBookTable);
//
//        db.execSQL(insertData);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addBook(HotAdapter_Helper book) {
        String desc[] = {
                "Mô tả này dành cho truyện của Harper Lee ",
                "Mô tả này dành cho truyện của Franz Kafka",
                "Mô tả này dành cho truyện của J.D. Salinger",
                "Mô tả này dành cho truyện của Fyodor Dostoevsky",
                "Mô tả này dành cho truyện của Leo Tolstoy",
                "Mô tả này dành cho truyện của Charles Dickens",
                "Mô tả này dành cho truyện của Antoine de Saint-Exupéry  ",
                "Mô tả này dành cho truyện của Gabriel Garcia Marquez",
                "Mô tả này dành cho truyện của Xuân Diệu",
                "Mô tả này dành cho truyện của Dan Brown ",
                "Mô tả này dành cho truyện của  Arthur Conan Doyle",
                "Mô tả này dành cho truyện của Thomas Harris",
                "Mô tả này dành cho truyện của Agatha Christie"
        };
        String subject[] = {"Kinh dị", "Trinh thám", "Ngôn tình",
                "Tiểu thuyết", "Anime", "Khoa học", "Kinh dị",
                "Trinh thám", "Ngôn tình", "Kinh dị", "Trinh thám",
                "Ngôn tình", "Ngôn tình"};
        String author[] = {"Harper Lee", "Franz Kafka",
                "J.D. Salinger", "Fyodor Dostoevsky",
                "Leo Tolstoy", "Charles Dickens ",
                "Antoine de Saint-Exupéry ", "Gabriel Garcia Marquez",
                "Xuân Diệu", "Dan Brown", " Arthur Conan Doyle",
                "Thomas Harris", "Agatha Christie"};
        String title[] = {"Giết con chim nhại", "Vụ án",
                "Bắt trẻ đồng xanh", "Anh em nhà Karamazov", "Anna Karenina",
                "Hồn ma đêm Giáng sinh", "Hoàng tử bé", "Trăm năm cô đơn",
                "Nhất định phải nói yêu anh", "Mật mã Da Vinci", "Sherlock Holmes",
                "Sự im lặng của bầy cừu", "Án mạng trên sông Nile"};
        String[] imgs = {
                "slider1", "slider2", "img_2",
                "slider4", "slider5", "slider5", "img_3", "img_3", "img_3",
                "slider4", "slider4", "slider4", "slider4"};

    }


}
