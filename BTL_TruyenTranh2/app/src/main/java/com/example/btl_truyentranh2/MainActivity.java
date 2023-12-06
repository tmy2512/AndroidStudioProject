package com.example.btl_truyentranh2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import Gridview_TruyenHot.HotAdapter_Helper;
import Gridview_TruyenHot.TruyenHot_Adapter;

public class MainActivity extends AppCompatActivity {
    // khai báo flipper

 MediaPlayer mp ;
    ViewFlipper viewFlipper;
    GridView gridView, gridview2, gridview3, gridview4;
    RecyclerView recyclerView;
    ImageView ic_search;
    TextView seeall;
    ArrayList<HotAdapter_Helper> list_book_adapter, list_book_kd, list_book_rcm;
    ArrayList<Recommend_Helper> list_book;
    HotAdapter_Helper hotAdapterHelper;
    Recommend_Helper recommendHelper;
    Recommend_Adapter recommendAdapter;
    TruyenHot_Adapter truyenHot_adapter;
    Database database;
//    SQLiteDatabase data = database.getWritableDatabase();

    // declare resource for adapter data
    String[] name_novel = {"Sự lựa chọn của em chỉ có thể là anh", "Yêu tinh nhỏ", "Nàng đến cùng ánh trăng", "Bí mật nguy hiểm, xin anh tha thứ"};
    int imgs_novel[] = {
            R.drawable.img, R.drawable.img1, R.drawable.img_1, R.drawable.img_2
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setWifiManager(wifiManager);
        AnhXa();
        SlideShow();
        show_gridview_custom_truyenhot();
        show_gridview_custom_tpkinhdien();
        recommend_recycleview();
//        mp =  MediaPlayer.create(MainActivity.this, R.raw.);
        mp.start();
        ic_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Search.class);
                startActivity(i);
            }
        });
    }


    public void sliderImage(int image) {
        // slider chỉ mới là frame để đặt ảnh, vì thế trong frame phải gán 1 view là Imageview
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(image);
        // load view vào flipper
        viewFlipper.addView(imageView);
        // set timer
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);
        // set animation
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        viewFlipper.showPrevious();
    }
    public void SlideShow() {
        // khai báo mảng ảnh cần load vào flipper
        int images[] = {R.drawable.slider5, R.drawable.slider4, R.drawable.slider1};
        // create foreach
        for (int img : images)
            sliderImage(img);
    }
    public void show_gridview_custom_truyenhot() {
//        list_book_adapter = new ArrayList<>();
//        String title, author, desc, subj, image, name_pdf;
        database = new Database(MainActivity.this);
        database.Query(Database.createBookTable);
//        database.Query(Database.insertData);
        Cursor datashow = database.cursor("SELECT * FROM "+Database.tableName);
        list_book_adapter = new ArrayList<>();
//        while(datashow.moveToNext()) {
//            image = datashow.getString(0);
//            title = datashow.getString(1);
//            author = datashow.getString(2);
//            desc = datashow.getString(3);
//            subj = datashow.getString(4);
//            name_pdf = datashow.getString(5);
//            list_book_adapter.add(new HotAdapter_Helper(image, title, author, desc, subj, name_pdf));
//        }
        Toast.makeText(MainActivity.this, "dsjkgfjdsfdsfdsf", Toast.LENGTH_SHORT).show();
//
                        TruyenHot_Adapter truyenHot_adapter = new TruyenHot_Adapter(MainActivity.this, list_book_adapter, R.layout.view_in_gridview);
//                        truyenHot_adapter.notifyDataSetChanged();
//                        gridView.setAdapter(truyenHot_adapter);

            // Thêm dữ liệu vào list
        String desc[] = {
                "Mô tả này dành cho truyện của Harper Lee 1234543hhdfjds foiwe dsfh ehfi ieuwofie jđj",
                "Mô tả này dành cho truyện của Franz Kafka",
                "Mô tả này dành cho truyện của J.D. Salinger",
                "Mô tả này dành cho truyện của Fyodor Dostoevsky",
                "Mô tả này dành cho truyện của Leo Tolstoy",
                "Mô tả này dành cho truyện của Charles Dickens",
        };
        String subject[] = {"Kinh dị", "Trinh thám", "Ngôn tình", "Tiểu thuyết", "Anime", "Khoa học"};
        String author[] = {"Harper Lee", "Franz Kafka", "J.D. Salinger", "Fyodor Dostoevsky", "Leo Tolstoy", "Charles Dickens "};
        String title[] = {"Giết con chim nhại", "Vụ án",
                "Bắt trẻ đồng xanh", "Anh em nhà Karamazov", "Anna Karenina", "Hồn ma đêm Giáng sinh"};

        String imgs[] = {
               "slider1",  "slider2", "img_2",
                "slider4", "slider5", "slider5"};
        String name_pdf[] = {"tailieu.pdf", "truyen2.pdf", "tailieu.pdf", "truyen2.pdf", "tailieu.pdf", "truyen2.pdf"};


        for(int i = 0 ; i<imgs.length; i++){
            hotAdapterHelper = new HotAdapter_Helper(imgs[i], title[i], author[i], desc[i], subject[i], name_pdf[i]);
            list_book_adapter.add(hotAdapterHelper);
        }
        // declare adapter
         truyenHot_adapter = new TruyenHot_Adapter(MainActivity.this, list_book_adapter, R.layout.view_in_gridview);
        gridView.setAdapter(truyenHot_adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, Trangconchinh.class).
                        putExtra("name_book", list_book_adapter.get(position).getTitle_book().toString()).
                        putExtra("author", list_book_adapter.get(position).getAuthor().toString()).
                        putExtra("img", list_book_adapter.get(position).getImg()).
                        putExtra("desc",  list_book_adapter.get(position).getDesc().toString()).
                        putExtra("subject", list_book_adapter.get(position).getSubject().toString()).
                        putExtra("name_pdf", list_book_adapter.get(position).getName_pdf()));

            }
        });

    }
//    void insertdata() {
//        database = new Database(this, "Listbook.sqlite", null, 1);
//        database.Query("CREATE TABLE IF NOT EXISTS " +
//                "Book2(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "Image CHAR(10), Title NVARCHAR(50), Author NVARCHAR(30), " +
//                "Desc NVARCHAR(100)," +
//                "Subj NVARCHAR(30))");
////        try {
////            database.Query("INSERT INTO Book2(Image, Title, Author, Desc, Subj) VALUES " +
////                    "('slider1', 'Name1', 'Kim Lân', " +
////                    "'Mô tả này dành cho truyện của Kim Lân 1234543hhdfjds foiwe dsfh ehfi ieuwofie jđj', 'Kinh dị')");
////            Toast.makeText(this, "dữ liệu đã được insert", Toast.LENGTH_SHORT).show();
////
////        }
////        catch(Exception e) {
////            Log.e("msg", "insert loi");
////        }
//            }
    public void show_gridview_custom_tpkinhdien() {
        // khai báo arraylist để thêm dữ liệu
       list_book_kd = new ArrayList<>();

        // cung cấp dữ liệu
        String desc[] = {
                "Mô tả này dành cho truyện của Antoine de Saint-Exupéry  1234543hhdfjds foiwe dsfh ehfi ieuwofie jđj",
                "Mô tả này dành cho truyện của Gabriel Garcia Marquez",
                "Mô tả này dành cho truyện của Xuân Diệu"
        };
        String subject[] = {"Kinh dị", "Trinh thám", "Ngôn tình"};
        String author[] = {"Antoine de Saint-Exupéry ", "Gabriel Garcia Marquez", "Xuân Diệu"};
        String title[] = {"Hoàng tử bé", "Trăm năm cô đơn", "Nhất định phải nói yêu anh"};

        String imgs[] = {
                "slider1",  "slider2", "img_2"};
        String name_pdf[] = {"tailieu.pdf", "truyen2.pdf", "tailieu.pdf"};
        for(int i = 0; i< imgs.length; i++) {
            hotAdapterHelper = new HotAdapter_Helper(imgs[i], title[i], author[i], desc[i], subject[i], name_pdf[i]);
            list_book_kd.add(hotAdapterHelper);
        }
        TruyenHot_Adapter adpt = new TruyenHot_Adapter(MainActivity.this, list_book_kd, R.layout.view_in_gridview );
        gridview2.setAdapter(adpt);
        // chuyển dữ liệu sang trang con chinh
        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, Trangconchinh.class);
                i.putExtra("img", list_book_kd.get(position).getImg());
                i.putExtra("name_book", list_book_kd.get(position).getTitle_book());
                i.putExtra("author", list_book_kd.get(position).getAuthor());
                i.putExtra("desc", list_book_kd.get(position).getDesc());
                i.putExtra("subject", list_book_kd.get(position).getSubject());
                i.putExtra("name_pdf", list_book_adapter.get(position).getName_pdf());
                startActivity(i);

            }
        });

    }
    // show recycleview
    public void recommend_recycleview() {
        // khai báo list chứa dữ liệu
     list_book_rcm = new ArrayList<>();
        // truyền dữ liệu cho list
        String desc[] = {
                "Mô tả này dành cho truyện của Dan Brown 1234543hhdfjds foiwe dsfh ehfi ieuwofie jđj",
                "Mô tả này dành cho truyện của  Arthur Conan Doyle",
                "Mô tả này dành cho truyện của Thomas Harris",
                "Mô tả này dành cho truyện của Agatha Christie"
        };
        String subject[] = {"Kinh dị", "Trinh thám", "Ngôn tình", "Ngôn tình"};
        String author[] = {"Dan Brown", " Arthur Conan Doyle", "Thomas Harris", "Agatha Christie"};
        String title[] = {"Mật mã Da Vinci", "Sherlock Holmes", "Sự im lặng của bầy cừu", "Án mạng trên sông Nile"};

        String imgs[] = {"slider1", "slider1", "slider1", "slider1",
        };
                String name_pdf[] = {"tailieu.pdf", "truyen2.pdf", "tailieu.pdf", "truyen2.pdf"};


        for(int i = 0; i<imgs.length; i++) {
            hotAdapterHelper = new HotAdapter_Helper(imgs[i], title[i], author[i], desc[i], subject[i], name_pdf[i]);
            list_book_rcm.add(hotAdapterHelper);
        }
        //tối ưu hoá ở adapter
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

         Recommend_Adapter adapter = new Recommend_Adapter(MainActivity.this, list_book_rcm);
        recyclerView.setAdapter(adapter);
        seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SeeAll.class);
                startActivity(i);
            }
        });
    }



    void AnhXa() {
        viewFlipper = findViewById(R.id.vf);
        gridView = findViewById(R.id.gridview);
        gridview2 = findViewById(R.id.gridview2);
        recyclerView = (RecyclerView) findViewById(R.id.recommend_recycleview);
        ic_search = findViewById(R.id.search);
        seeall = findViewById(R.id.txtmore);
    }

}